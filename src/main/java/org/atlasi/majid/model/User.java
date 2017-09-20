package org.atlasi.majid.model;

import java.util.Date;

public class User {

	private String userName;
	private final String accessToken;
	private final Date creationDate;
	private long numOfNotificationsPushed = 0;

	public User(String userName, String accessToken) {
		super();
		this.setUserName(userName);
		this.accessToken = accessToken;
		this.creationDate = new Date(); 
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

	public Date getCreationDate() {
		return creationDate;
	}

    public void incrementNumOfNotificationsPushed() {
    	setNumOfNotificationsPushed(getNumOfNotificationsPushed() + 1);
    }

	public long getNumOfNotificationsPushed() {
		return numOfNotificationsPushed;
	}

	public void setNumOfNotificationsPushed(long numOfNotificationsPushed) {
		this.numOfNotificationsPushed = numOfNotificationsPushed;
	}
}
