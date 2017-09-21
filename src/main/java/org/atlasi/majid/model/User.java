package org.atlasi.majid.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class User {

	private String userName;
	private String accessToken;
	private String creationDate;
	private long numOfNotificationsPushed = 0;

	public User() {
		String pattern = "yyyy-MM-dd'T'HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		this.setCreationDate(sdf.format(new Date()));
	}

	public User(String username, String accesstoken) {
		this.setUserName(username);
		this.setAccessToken(accesstoken);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public boolean incrementNumOfNotificationsPushed() {
		setNumOfNotificationsPushed(getNumOfNotificationsPushed() + 1);
		return true;
	}

	public long getNumOfNotificationsPushed() {
		return numOfNotificationsPushed;
	}

	public void setNumOfNotificationsPushed(long numOfNotificationsPushed) {
		this.numOfNotificationsPushed = numOfNotificationsPushed;
	}

}
