package com.springboot.model.dbentity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TroubleTicket {

	@Id
	@GeneratedValue
	int id;
	String ticketNumber;
	String contactName;
	String openedBy;
	@JsonFormat(pattern="MM-dd-yyyy HH:mm a")
	Date openedDate;
	String deliveryDate;
	String informationDetail;
	String ticketReason;
	String description;
	int groupId;
	String vin;
	int assignedTo;
	String billingRate;
//	String recurringBill;
//	String flatRate;
	int statusId;
	int billable;
	String billingAddress;
	int siteId;
	String taxRate;
	@JsonFormat(pattern="MM/dd/yyyy hh:mm a")
	Date slaTime;
	String completedBy;
	@JsonFormat(pattern="MM/dd/yyyy hh:mm a")
	Date completedTime;
	@JsonFormat(pattern="dd-MM-yyyy hh:mm a")
	Date closedTime;
	String closedBy;
	String lastUpdatedBy;
	@JsonFormat(pattern="dd-MM-yyyy hh:mm a")
	Date lastUpdated;
	int slaFlag;
	int resolutionCode;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getOpenedBy() {
		return openedBy;
	}
	public void setOpenedBy(String openedBy) {
		this.openedBy = openedBy;
	}
	public Date getOpenedDate() {
		return openedDate;
	}
	public void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}
	
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getInformationDetail() {
		return informationDetail;
	}
	public void setInformationDetail(String informationDetail) {
		this.informationDetail = informationDetail;
	}
	
	public String getTicketReason() {
		return ticketReason;
	}
	public void setTicketReason(String ticketReason) {
		this.ticketReason = ticketReason;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public int getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	public String getBillingRate() {
		return billingRate;
	}
	public void setBillingRate(String billingRate) {
		this.billingRate = billingRate;
	}
	
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	public int getBillable() {
		return billable;
	}
	public void setBillable(int billable) {
		this.billable = billable;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public String getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}
	public Date getSlaTime() {
		return slaTime;
	}
	public void setSlaTime(Date slaTime) {
		this.slaTime = slaTime;
	}
	
	public String getCompletedBy() {
		return completedBy;
	}
	public void setCompletedBy(String completedBy) {
		this.completedBy = completedBy;
	}
	public Date getCompletedTime() {
		return completedTime;
	}
	public void setCompletedTime(Date completedTime) {
		this.completedTime = completedTime;
	}
	public Date getClosedTime() {
		return closedTime;
	}
	public void setClosedTime(Date closedTime) {
		this.closedTime = closedTime;
	}
	public String getClosedBy() {
		return closedBy;
	}
	public void setClosedBy(String closedBy) {
		this.closedBy = closedBy;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public int getSlaFlag() {
		return slaFlag;
	}
	public void setSlaFlag(int slaFlag) {
		this.slaFlag = slaFlag;
	}
	public int getResolutionCode() {
		return resolutionCode;
	}
	public void setResolutionCode(int resolutionCode) {
		this.resolutionCode = resolutionCode;
	}
	
	
}
