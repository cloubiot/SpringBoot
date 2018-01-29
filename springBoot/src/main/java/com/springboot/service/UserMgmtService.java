package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.clib.util.JSONUtil;
import com.springboot.dao.AddressRepository;
import com.springboot.dao.UserMgmtRepository;
import com.springboot.dao.UserQuery;
import com.springboot.dao.UserRoleMappingRepository;
import com.springboot.model.dbentity.Address;
import com.springboot.model.dbentity.User;
import com.springboot.model.dbentity.UserRoleMapping;
import com.springboot.model.usermgmt.AddUpdateAddressRequest;
import com.springboot.model.usermgmt.UserDetail;
import com.springboot.model.usermgmt.UserWithRole;

@Service
@Transactional
public class UserMgmtService {

	@Autowired
	UserMgmtRepository userMgmtRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	UserRoleMappingRepository userRoleMappingRepository;
	
	@Autowired
	UserQuery userQuery;
	
	public User saveUser(User user){
		return this.userMgmtRepository.save(user);
	}
	
	public User login(String userName,String password){
		return this.userQuery.login(userName, password);	}
	
	public Address getAddressByUser(int id){
		return this.addressRepository.findByUserId(id);
	}
	
	
	public Address saveAddress(Address address){
		return this.addressRepository.save(address);
	}
	public User getByUserName(String userName){
		return this.userMgmtRepository.findByEmail(userName);
	}
	
	public User getByEmail(String email){
		return this.userMgmtRepository.findByEmail(email);
	}
	public User emailIdExists(String email,int userId){
		return this.userQuery.emailIdExists(email, userId);
	}
	public User getByIdAndPassword(int id,String password){
		return this.userMgmtRepository.findByIdAndPassword(id, password);
	}
	
	public long getUserRoleId(long userId){
		return this.userQuery.getUserRoleId(userId);
	}
	
	public User getUserById(int id){
		return this.userMgmtRepository.findById(id);
	}
	public Address addUpdateAddress(Address address){
		System.out.println(JSONUtil.toJson(address));
		return addressRepository.save(address);
	}
	public List<UserWithRole> getUserList(int roleId){
		return this.userQuery.getUserList(roleId);
	}
	public Address getByAddressId(int id){
		return this.addressRepository.findById(id);
	}
	public List<UserWithRole> searchUser(String name,int roleId){
		return this.userQuery.searchUser(name,roleId);
	}
	public List<UserDetail> getUserDetail(){
		return this.userQuery.getUserDetail();
	}
	public Address getAddressByUserIdAndType(int id,int type){
		return this.addressRepository.findByUserIdAndAddressType(id, type);
	}
	public UserRoleMapping saveUserRole(UserRoleMapping userRole){
		return this.userRoleMappingRepository.save(userRole);
	}
	public UserRoleMapping getRoleByUserId(int id){
		return this.userRoleMappingRepository.findByUserId(id);
	}
	public List<UserDetail> getUserByPagination(int from,int to){
		return this.userQuery.getPaginationForUser(from, to);
	}
	public List<UserDetail> searchUserDetail(String name,String mailId,String phoneNumber,String role,String active){
		return this.userQuery.searchUserDetail(name, mailId, phoneNumber, role,active);
	}
	public List<UserDetail> getActiveUser(String value){
		return this.userQuery.getActiveUser(value);
	}
	
}
