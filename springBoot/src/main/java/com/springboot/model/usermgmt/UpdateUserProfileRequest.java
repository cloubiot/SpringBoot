package com.springboot.model.usermgmt;

import com.springboot.model.dbentity.User;

public class UpdateUserProfileRequest {

	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
