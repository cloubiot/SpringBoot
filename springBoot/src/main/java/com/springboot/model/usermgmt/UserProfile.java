package com.springboot.model.usermgmt;

import com.springboot.model.dbentity.Address;
import com.springboot.model.dbentity.User;

public class UserProfile {

	User user;
	Address address;
	int roleId;
	
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
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
}
