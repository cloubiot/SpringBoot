package com.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.model.dbentity.UserRoleMapping;

public interface UserRoleMappingRepository extends CrudRepository<UserRoleMapping,Long> {
	
	UserRoleMapping findByUserId(int id);

}
