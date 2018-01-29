package com.springboot.model.usermgmt;

import com.springboot.clib.model.BaseResponse;
import com.springboot.model.dbentity.User;

public class UpdateUserProfileResponse extends BaseResponse{

	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
