package com.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.model.dbentity.User;

public interface UserMgmtRepository extends CrudRepository<User,Long> {

	User findByUserNameAndPassword(String userName,String password);
	User findByUserName(String userName);
	User findByEmail(String email);
	User findByIdAndPassword(int id,String password);
	User findById(int id);
	
}