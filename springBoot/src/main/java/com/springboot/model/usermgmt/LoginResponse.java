package com.springboot.model.usermgmt;

import com.springboot.clib.model.BaseResponse;
import com.springboot.model.dbentity.Address;
import com.springboot.model.dbentity.User;

public class LoginResponse extends BaseResponse{

	User user;
	Address address;
	long roleId;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	
	
}
