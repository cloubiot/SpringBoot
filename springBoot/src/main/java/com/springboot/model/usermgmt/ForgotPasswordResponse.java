package com.springboot.model.usermgmt;

import com.springboot.clib.model.BaseResponse;

public class ForgotPasswordResponse extends BaseResponse{

	String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
