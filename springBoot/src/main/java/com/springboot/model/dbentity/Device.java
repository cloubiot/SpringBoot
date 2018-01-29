package com.springboot.model.dbentity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Device {

	@Id
	@GeneratedValue
	int id;
	String deviceType;
	String vin;
	int statusId;
	boolean isActive;
	@JsonFormat(pattern="MM-dd-yyyy")
	Date complianceDate;
	String baseLocation;
	String deployLocation;
	@JsonFormat(pattern="dd-MM-yyyy")
	Date createdDate;
	@JsonFormat(pattern="dd-MM-yyyy")
	Date lastModDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public Date getComplianceDate() {
		return complianceDate;
	}
	public void setComplianceDate(Date complianceDate) {
		this.complianceDate = complianceDate;
	}
	public String getBaseLocation() {
		return baseLocation;
	}
	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}
	public String getDeployLocation() {
		return deployLocation;
	}
	public void setDeployLocation(String deployLocation) {
		this.deployLocation = deployLocation;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModDate() {
		return lastModDate;
	}
	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}
	
	
	
}
