package org.atlasi.majid.service;

import org.atlasi.majid.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserServiceImplTest {

	private static final String userName1 = "MyName1";
	private static final String accessToken1 = "XYZ1";
	private static final String userName2 = "MyName2";
	private static final String accessToken2 = "XYZ2";
	private static final String userName3 = "MyName3";
	private static final String accessToken3 = "XYZ3";
	private static final String userName4 = "MyName4";
	private static final String accessToken4 = "XYZ4";

	User user1;
	User user2;
	User user3;
	User user4;

	private UserService userService;

	@Before
	public void setUp() throws Exception {
		userService = new UserServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveUser() {
		user1 = new User(userName1, accessToken1);
		userService.saveUser(user1);
		Assert.assertEquals(user1, userService.findByName(userName1));
	}

	@Test
	public void testFindByName() throws Exception {
		user2 = new User(userName2, accessToken2);
		userService.saveUser(user2);
		Assert.assertEquals(user2, userService.findByName(userName2));
	}

	@Test
	public void testFindAllUsers() {
		user3 = new User(userName3, accessToken3);
		user4 = new User(userName4, accessToken4);
		
		UserService userSer = new UserServiceImpl();
		userSer.findAllUsers().size();
		userSer.saveUser(user3);
		userSer.findAllUsers().size();
		userSer.saveUser(user4);
		Assert.assertEquals(2, userSer.findAllUsers().size());
	}

	@Test
	public void testUserExists() {
		User user1 = new User(userName1, accessToken1);
		userService.saveUser(user1);
		Assert.assertTrue(userService.userExists(user1));
	}

	@Test
	public void testIncrementNumOfNotificationsPushed() {
		User user1 = new User(userName1, accessToken1);
		userService.saveUser(user1);
		Assert.assertTrue(userService.incrementNumOfNotificationsPushed(user1));
	}

}
