package com.springboot.model.usermgmt;

import com.springboot.clib.model.BaseResponse;
import com.springboot.model.dbentity.Address;

public class BillingAddressResponse extends BaseResponse {

	Address billingAddress;

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	
}
