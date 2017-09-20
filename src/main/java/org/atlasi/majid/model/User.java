package org.atlasi.majid.model;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class User {

	private String userName;
	private  String accessToken;
	private  Date creationDate;
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
	
	public JSONObject userCreatedToJson() {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put(userName, getUserName());
			jsonObject.put(accessToken, getAccessToken());
			jsonObject.put("creationTime", getCreationDate().toString());
			jsonObject.put("numOfNotificationsPushed", new Long(getNumOfNotificationsPushed()).toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
}
