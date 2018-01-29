package com.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.model.dbentity.Address;

public interface AddressRepository extends CrudRepository<Address,Long>{

	Address findByUserId(int userId);
	Address findById(int id);
	Address findByUserIdAndAddressType(int id,int type);
}
