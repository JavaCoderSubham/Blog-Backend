package com.blog.userInfo.service;

import java.util.List;

import com.blog.userInfo.dto.UserInfoDto;
import com.blog.userInfo.entity.UserInfo;
import com.blog.userInfo.entity.UserProjectionEmail;
import com.blog.userInfo.entity.UserProjectionPhoneNo;
import com.blog.userInfo.exception.RecordNotFound;

public interface UserService {

	UserInfo create(UserInfo user);
	List<UserInfoDto> getAll();
	UserInfoDto getById(String id) throws RecordNotFound;
	String deleteById(String id) throws RecordNotFound;
	UserInfo update(UserInfo userDetails , String id);
	
	//***************************************//
	
	List<UserInfoDto> findByName(String name) throws RecordNotFound;
	
	List<UserInfoDto> findByAddressCity(String city) throws RecordNotFound;
	
	List<UserInfoDto> findByAddressState(String state) throws RecordNotFound;
	
	UserProjectionEmail findByEmail(String email) throws RecordNotFound;
	
	UserProjectionPhoneNo findByPhoneNo(String phoneNo) throws RecordNotFound;
	
	void changePassword(String email, String password) throws RecordNotFound;
}


