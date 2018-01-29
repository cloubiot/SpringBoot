package com.springboot.model.dbentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SiteMapping {
	
	@Id
	@GeneratedValue
	int id;
	String siteId;
	int userId;
	int addressId;
	String accessInfo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAccessInfo() {
		return accessInfo;
	}
	public void setAccessInfo(String accessInfo) {
		this.accessInfo = accessInfo;
	}
	
	
	
}
