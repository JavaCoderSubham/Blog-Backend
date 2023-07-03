package com.blog.userInfo.service;

import java.util.List;

import com.blog.userInfo.entity.UserInfo;
import com.blog.userInfo.exception.RecordNotFound;

public interface UserService {

	UserInfo create(UserInfo user);
	List<UserInfo> getAll();
	UserInfo getById(String id) throws RecordNotFound;
	String deleteById(String id) throws RecordNotFound;
	UserInfo update(UserInfo userDetails , String id);
	
	//***************************************//
	
	List<UserInfo> findByName(String name) throws RecordNotFound;
	
//	List<UserInfo> findByCity(String city) throws NotFound;
//	
//	List<UserInfo> findByState(String state) throws NotFound;
	
	UserInfo findByEmail(String email) throws RecordNotFound;
	
	UserInfo findByPhoneNo(String phoneNo) throws RecordNotFound;	
}


