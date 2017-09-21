package org.atlasi.majid.controller;

import java.util.Map;

import org.atlasi.majid.model.User;
import org.atlasi.majid.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    UserService userService;
    
    // Create a User
    @SuppressWarnings("unchecked")
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

	
	
}
