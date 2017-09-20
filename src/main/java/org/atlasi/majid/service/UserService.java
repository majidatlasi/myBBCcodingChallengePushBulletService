package org.atlasi.majid.service;

import java.util.List;

import org.atlasi.majid.model.User;

public interface UserService {

	User findByName(String name);

	void saveUser(User user);

	List<User> findAllUsers();

	boolean userExists(User user);

	void incrementNumOfNotificationsPushed(User user);
}
