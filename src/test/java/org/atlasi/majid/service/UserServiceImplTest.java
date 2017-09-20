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
			User user = new User(userName1, accessToken1);
			userService.saveUser(user);
			Assert.assertEquals(user, userService.findByName(userName1));
	 }

	@Test
	public void testFindByName() throws Exception {
		User user = new User(userName1, accessToken1);
		userService.saveUser(user);
		Assert.assertEquals(user, userService.findByName(userName1));
	}

	 @Test
	 public void testFindAllUsers() {
			User user1 = new User(userName1, accessToken1);
			userService.saveUser(user1);
			User user2 = new User(userName2, accessToken2);
			userService.saveUser(user2);
			Assert.assertEquals(2, userService.findAllUsers().size());
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
