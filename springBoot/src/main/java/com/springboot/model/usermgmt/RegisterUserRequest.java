package com.springboot.model.usermgmt;

import com.springboot.model.dbentity.Address;
import com.springboot.model.dbentity.SiteMapping;
import com.springboot.model.dbentity.User;

public class RegisterUserRequest {

	User user;
	Address baseAddress;
	Address siteAddress;
	SiteMapping siteMapping;
	int role;
	int groupId;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getBaseAddress() {
		return baseAddress;
	}
	public void setBaseAddress(Address baseAddress) {
		this.baseAddress = baseAddress;
	}
	public Address getSiteAddress() {
		return siteAddress;
	}
	public void setSiteAddress(Address siteAddress) {
		this.siteAddress = siteAddress;
	}
	public SiteMapping getSiteMapping() {
		return siteMapping;
	}
	public void setSiteMapping(SiteMapping siteMapping) {
		this.siteMapping = siteMapping;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	
}
