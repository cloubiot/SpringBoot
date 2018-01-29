package com.springboot.model.usermgmt;

import java.util.List;

import com.springboot.clib.model.BaseResponse;

public class UserDetailResponse extends BaseResponse{

	List<UserDetail> userDetail;

	public List<UserDetail> getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(List<UserDetail> userDetail) {
		this.userDetail = userDetail;
	}
	
}
