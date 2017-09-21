package org.atlasi.majid.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private static final String userName = "myName";
	private static final String accessToken = "XYZ";
	private User user;

	@Before
	public void setUp() throws Exception {
		user = new User(userName, accessToken);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetUserName() {
		Assert.assertEquals(userName, user.getUserName());

	}

	@Test
	public void testGetAccessToken() {
		Assert.assertEquals(accessToken, user.getAccessToken());
	}

	@Test
	public void testGetNumOfNotificationsPushed() {
		Assert.assertEquals(0, user.getNumOfNotificationsPushed());
	}

	@Test
	public void testIncrementNumOfNotificationsPushed() {
		user.incrementNumOfNotificationsPushed();
		user.incrementNumOfNotificationsPushed();
		Assert.assertEquals(2, user.getNumOfNotificationsPushed());
	}

	@Test
	public void testGetCreationDate() {
		User user1 = new User();
		assertNotNull(user1.getCreationDate());
	}

}
