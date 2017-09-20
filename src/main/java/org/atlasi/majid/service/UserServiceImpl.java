package org.atlasi.majid.service;

import java.util.ArrayList;
import java.util.List;

import org.atlasi.majid.model.User;

public class UserServiceImpl implements UserService {

	private List<User> userList = new ArrayList<User>();
	
	@Override
	public User findByName(String name) {
		User foundUser= null;
		for(User user: userList) {
			if (user.getUserName().compareToIgnoreCase(name) == 0) {
				foundUser = user;
			} 
		}
		return foundUser;
	}

	@Override
	public void saveUser(User user) {
		userList.add(user);

	}

	@Override
	public List<User> findAllUsers() {
		return userList;
	}

	@Override
	public boolean userExists(User user1) {
		boolean found= false;
		for(User user: userList) {
			if (user.getUserName().compareToIgnoreCase(user1.getUserName()) == 0) {
				found = true;
			} 
		}
		return found;
	}

	@Override
	public boolean incrementNumOfNotificationsPushed(User user) {
		return user.incrementNumOfNotificationsPushed();
	}

}