package com.springboot.model.usermgmt;

import com.springboot.clib.model.BaseResponse;
import com.springboot.model.dbentity.Address;
import com.springboot.model.dbentity.SiteMapping;

public class AddressResponse extends BaseResponse {

	Address address;
	SiteMapping siteMapping;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public SiteMapping getSiteMapping() {
		return siteMapping;
	}

	public void setSiteMapping(SiteMapping siteMapping) {
		this.siteMapping = siteMapping;
	}
	
	
}
