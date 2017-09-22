package org.atlasi.majid.controller;

import java.util.List;

import org.atlasi.majid.model.PushBulletMessageBody;
import org.atlasi.majid.model.PushMessageBody;
import org.atlasi.majid.model.User;
import org.atlasi.majid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class MainController {

	@Autowired
	UserService userService;

	// Create a User
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "user/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user) {
		if (userService.userExists(user)) {
			return new ResponseEntity("Unable to create user already exist.", HttpStatus.CONFLICT);
		}
		String userName = user.getUserName();

		userService.saveUser(user);
		user = userService.findByName(userName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	// Retrieve all registered users
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// Push notification
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "push/", method = RequestMethod.POST)
	public ResponseEntity<?> pushNotificationToUser(@RequestBody PushMessageBody pushMessage) {

		User user = userService.findByName(pushMessage.getUserName());

		if (user != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			headers.add("Access-Token", user.getAccessToken());

			PushBulletMessageBody pushBulletMessageBody = new PushBulletMessageBody();
			pushBulletMessageBody.setTitle("New Note");
			pushBulletMessageBody.setType("note");
			pushBulletMessageBody.setBody(pushMessage.getPushMessage());
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<PushBulletMessageBody> response = restTemplate.postForEntity("https://api.pushbullet.com/v2/pushes", pushBulletMessageBody, PushBulletMessageBody.class);
			HttpStatus status = response.getStatusCode();
			if (status == HttpStatus.OK) {
				return new ResponseEntity<PushBulletMessageBody>(pushBulletMessageBody, HttpStatus.OK);
				
			} 

		} 
		return new ResponseEntity("Unable to push the message.", HttpStatus.BAD_REQUEST);

	}

}
