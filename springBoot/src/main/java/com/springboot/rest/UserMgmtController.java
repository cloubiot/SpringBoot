package com.springboot.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.clib.model.SuccessIDResponse;
import com.springboot.clib.service.EmailService;
import com.springboot.clib.service.EmailTemplateService;
import com.springboot.clib.util.JSONUtil;
import com.springboot.clib.util.RandomPassword;
import com.springboot.clib.util.SecureData;
import com.springboot.model.dbentity.Address;
import com.springboot.model.dbentity.GroupMapping;
import com.springboot.model.dbentity.SiteMapping;
import com.springboot.model.dbentity.User;
import com.springboot.model.dbentity.UserRoleMapping;
import com.springboot.model.email.EmailMessage;
import com.springboot.model.usermgmt.ActiveRequest;
import com.springboot.model.usermgmt.AddUpdateAddressRequest;
import com.springboot.model.usermgmt.AddressResponse;
import com.springboot.model.usermgmt.BillingAddressResponse;
import com.springboot.model.usermgmt.ChangePasswordRequest;
import com.springboot.model.usermgmt.EmailIdExistRequest;
import com.springboot.model.usermgmt.EmailIdExistResponse;
import com.springboot.model.usermgmt.ForgotPasswordRequest;
import com.springboot.model.usermgmt.ForgotPasswordResponse;
import com.springboot.model.usermgmt.ForgotUsernameRequest;
import com.springboot.model.usermgmt.ForgotUsernameResponse;
import com.springboot.model.usermgmt.LoginRequest;
import com.springboot.model.usermgmt.LoginResponse;
import com.springboot.model.usermgmt.RegisterUserRequest;
import com.springboot.model.usermgmt.RegisterUserResponse;
import com.springboot.model.usermgmt.SearchUserDetailRequest;
import com.springboot.model.usermgmt.SearchUserRequest;
import com.springboot.model.usermgmt.UpdateUserProfileRequest;
import com.springboot.model.usermgmt.UpdateUserProfileResponse;
import com.springboot.model.usermgmt.UserDetail;
import com.springboot.model.usermgmt.UserDetailResponse;
import com.springboot.model.usermgmt.UserListResponse;
import com.springboot.model.usermgmt.UserNameExistsRequest;
import com.springboot.model.usermgmt.UserNameExistsResponse;
import com.springboot.model.usermgmt.UserProfile;
import com.springboot.model.usermgmt.UserSignupRequest;
import com.springboot.model.usermgmt.UserWithRole;
import com.springboot.service.UserMgmtService;

@RestController
@RequestMapping("/usermgmt")
@CrossOrigin( maxAge = 3600)
public class UserMgmtController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserMgmtController.class);
	
	@Autowired
	private UserMgmtService userMgmtService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private EmailTemplateService emailTemplateService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/registerUser")
	public SuccessIDResponse registerUser(@RequestBody UserSignupRequest request) {
		SuccessIDResponse response = new SuccessIDResponse();
		
		try{
			User user = new User();
			SecureData sd = new SecureData();
			String encryptedPassword = sd.encrypt(request.getPassword());
			user.setUserName(request.getUserName());
			user.setFirstName(request.getFirstName());
			user.setLastName(request.getLastName());
			user.setPassword(encryptedPassword);
			user.setEmail(request.getEmail());
			user.setPhoneNumber(request.getPhoneNumber());
			userMgmtService.saveUser(user);
			logger.info("create user");
		}
		catch(Exception e){
			logger.error("create user failied",e);
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public LoginResponse login(@RequestBody LoginRequest request){
		LoginResponse response = new LoginResponse();
		try{
			System.out.println("login " +request.getUserName()+" pass "+request.getPassword());
			SecureData sd = new SecureData();
			String encryptedPassword = sd.encrypt(request.getPassword());
			System.out.println(encryptedPassword);
			UserProfile userProfile = new UserProfile();
			User user = userMgmtService.login(request.getUserName(), encryptedPassword);
			if(user != null){
				response.setUser(user);
				Address address = userMgmtService.getAddressByUserIdAndType(user.getId(),0);
				response.setAddress(address);
			}
			else{
				response.setSuccess(false);
				logger.info("invalid login");
			}
			try{
				long roleId = userMgmtService.getUserRoleId(user.getId());
				response.setRoleId(roleId);
			}catch(Exception e){
				logger.error("roleId not available", e);
			}
			
		}
		catch(Exception e){
			logger.error("login Failed",e);
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addUpdateAddress")
	public SuccessIDResponse addUpdateAddress(@RequestBody AddUpdateAddressRequest request) {
		SuccessIDResponse response = new SuccessIDResponse();
		try {
			System.out.println(JSONUtil.toJson(request.getAddress()));
			Address address = userMgmtService.addUpdateAddress(request.getAddress());
			response.setId(address.getId());
			logger.info("Add update address success");
		} catch (Exception e) {
			logger.error("Add update address failed", e);
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/userNameExists")
	public UserNameExistsResponse userNameExists(@RequestBody UserNameExistsRequest request){
		UserNameExistsResponse response = new UserNameExistsResponse();
		try{
			User user = userMgmtService.getByUserName(request.getUserName());
			if(user != null)
				response.setUserNameExists(true);
			else
				response.setUserNameExists(false);
				response.setSuccess(false);
		}
		catch(Exception e){
			logger.error("userName exists failed",e);
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/emailIdExist")
	public EmailIdExistResponse emailIdExist(@RequestBody EmailIdExistRequest request){
		EmailIdExistResponse response = new EmailIdExistResponse();
		try{
			User user = userMgmtService.getByEmail(request.getEmailId());
			if(user != null)
				response.setEmailIdExist(true);
			else
				response.setEmailIdExist(false);
		}
		catch(Exception e){
			logger.error("invalid EmailId", e);
			response.setSuccess(false);
		}
		
		return response;
	}
	@RequestMapping(method = RequestMethod.POST, value = "/emailIdExistById")
	public EmailIdExistResponse emailIdExistById(@RequestBody EmailIdExistRequest request){
		EmailIdExistResponse response = new EmailIdExistResponse();
		try{
			System.out.println("checking emailid user "+request.getUserId());
			if(request.getUserId() != 0){
				User user = userMgmtService.emailIdExists(request.getEmailId(),request.getUserId());
				if(user != null)
					response.setEmailIdExist(false);
				else
					response.setEmailIdExist(true);
			}
			if(request.getUserId() == 0){
				User user = userMgmtService.getByEmail(request.getEmailId());
				if(user != null)
					response.setEmailIdExist(true);
				else
					response.setEmailIdExist(false);
			}
		}
		catch(Exception e){
			logger.error("invalid EmailId", e);
			response.setSuccess(false);
		}
		
		return response;
	}
	@RequestMapping(method = RequestMethod.POST, value = "/forgotPassword")
	public ForgotPasswordResponse forgotPassword(@RequestBody ForgotPasswordRequest request){
		ForgotPasswordResponse response = new ForgotPasswordResponse();
		try{
			User user = userMgmtService.getByUserName(request.getUserName());
			SecureData sd = new SecureData();
			String password = sd.decrypt(user.getPassword());
			response.setPassword(password);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("firstName", user.getFirstName());
			map.put("lastName", user.getLastName());
			map.put("userName", user.getUserName());
			map.put("password", password );
			String subject = "Your password for DCSolar ";
			String emailBody = emailTemplateService.getEmailTemplate("recoveryPassword.vm",map);
			EmailMessage emailMessage = new EmailMessage();
			emailMessage.setToEmail(user.getEmail());
			emailMessage.setSubject(subject);
			emailMessage.setEmailBody(emailBody);
			emailService.sendEmail(user.getEmail(), subject, emailBody);
			//emailService.send2EmailQueue(emailMessage);
		}
		catch(Exception e){
			logger.error("forgot password failed",e);
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/forgotUsername")
	public ForgotUsernameResponse forgotUsername(@RequestBody ForgotUsernameRequest request){
		ForgotUsernameResponse response = new ForgotUsernameResponse();
		try{
			User user = userMgmtService.getByEmail(request.getEmail());
			if(user != null){
				response.setUserName(user.getUserName());
				response.isSuccess();
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("firstName", user.getFirstName());
				map.put("lastName", user.getLastName());
				map.put("userName", user.getUserName());
				String subject = "Your username for DCSolar ";
				String emailBody = emailTemplateService.getEmailTemplate("recoveryUsername.vm",map);
				EmailMessage emailMessage = new EmailMessage();
				emailMessage.setToEmail(user.getEmail());
				emailMessage.setSubject(subject);
				emailMessage.setEmailBody(emailBody);
				emailService.sendEmail(user.getEmail(), subject, emailBody);
				//emailService.send2EmailQueue(emailMessage);
				
			}
		}
		catch(Exception e){
			logger.error("forgot usernamefailed",e);
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/changePassword")
	public SuccessIDResponse changePassword(@RequestBody ChangePasswordRequest request){
		SuccessIDResponse response = new SuccessIDResponse();
		try{
			System.out.println(request.getUserId());
			SecureData sd = new SecureData();
			String oldPassword = sd.encrypt(request.getOldPassword());
			System.out.println(oldPassword);
			SecureData sd1 = new SecureData();
			String newPassword = sd1.encrypt(request.getNewPassword());
			User user = userMgmtService.getByIdAndPassword(request.getUserId(), oldPassword);
			if(user == null){
				response.setSuccess(false);
			}
			else{
				user.setPassword(newPassword);
				response.setId(user.getId());
				logger.info("password changed");
			}
			user.setPassword(newPassword);
			userMgmtService.saveUser(user);
		}
		catch(Exception e){
			logger.error("change Password Failed",e);
		}
		return response;
	}
	@RequestMapping(method = RequestMethod.POST, value = "/updateUserProfile")
	public UpdateUserProfileResponse updateUserProfile(@RequestBody UpdateUserProfileRequest request){
		UpdateUserProfileResponse response = new UpdateUserProfileResponse();
		try{
			User user = userMgmtService.getUserById(request.getUser().getId());
			user.setEmail(request.getUser().getEmail());
			user.setFirstName(request.getUser().getFirstName());
			user.setLastName(request.getUser().getLastName());
			user.setPhoneNumber(request.getUser().getPhoneNumber());
			user.setProfileImageUrl(request.getUser().getProfileImageUrl());
			userMgmtService.saveUser(user);
			/*Map<String,Object> map = new HashMap<String,Object>();
			map.put("firstName", user.getFirstName());
			map.put("lastName", user.getLastName());
			map.put("userName", user.getUserName());
			String subject= "Your Profile has been updated Successfully";
			String emailBody = emailTemplateService.getEmailTemplate("userProfileUpdate.vm",map);
			EmailMessage emailMessage = new EmailMessage();
			emailMessage.setToEmail(user.getEmail());
			emailMessage.setSubject(subject);
			emailMessage.setEmailBody(emailBody);
			emailService.send2EmailQueue(emailMessage);*/
			logger.info("successfully update");
			user.setPassword("");
			response.setUser(user);

		}
		catch(Exception e){
			logger.error("invalid userId",e);
			response.setSuccess(false);
		}
		return response;
}
	
	@RequestMapping(method = RequestMethod.GET, value="generatePassword/{id}")
	public SuccessIDResponse generatePassword(@PathVariable int id){
		SuccessIDResponse response = new SuccessIDResponse();
		try{
			RandomPassword randomString = new RandomPassword();
			String password = randomString.generateRandomString(); 
			SecureData sd = new SecureData();
			String encrypt = sd.encrypt(password);
			User user = userMgmtService.getUserById(id);
			user.setPassword(encrypt);
			userMgmtService.saveUser(user);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("firstName", user.getFirstName());
			map.put("userName", user.getEmail());
			map.put("password", password );
			String subject = "Your Password for DCSolar";
			String emailBody = emailTemplateService.getEmailTemplate("register.vm",map);
			EmailMessage emailMessage = new EmailMessage();
			emailMessage.setToEmail(user.getEmail());
			emailMessage.setSubject(subject);
			emailMessage.setEmailBody(emailBody);
			emailService.sendEmail(user.getEmail(), subject, emailBody);
//			emailService.send2EmailQueue(emailMessage);
		}
		catch(Exception e){
			
		}
		return response;
	}
}
