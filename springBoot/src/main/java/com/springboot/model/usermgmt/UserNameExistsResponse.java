package com.springboot.model.usermgmt;

import com.springboot.clib.model.BaseResponse;

public class UserNameExistsResponse extends BaseResponse{

	boolean userNameExists;

	public boolean isUserNameExists() {
		return userNameExists;
	}

	public void setUserNameExists(boolean userNameExists) {
		this.userNameExists = userNameExists;
	}

}
