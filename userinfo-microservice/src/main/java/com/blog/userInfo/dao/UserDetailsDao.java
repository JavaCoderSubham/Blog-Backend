package com.blog.userInfo.dao;

import java.util.List;

import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.blog.userInfo.entity.UserInfo;
import com.blog.userInfo.exception.RecordNotFound;


public interface UserDetailsDao {

	UserInfo create(UserInfo user);
	List<UserInfo> getAll();
	UserInfo getById(String id) throws NotFound, RecordNotFound;
	String deleteById(String id) throws NotFound, RecordNotFound;
	UserInfo update(UserInfo userDetails , String id);
	
	//***************************************//
	
	List<UserInfo> findByName(String name) throws RecordNotFound;
	
//	List<UserInfo> findByCity(String city) throws NotFound;
//	
//	List<UserInfo> findByState(String state) throws NotFound;
	
	UserInfo findByEmail(String email) throws RecordNotFound;
	
	UserInfo findByPhoneNo(String phoneNo) throws  RecordNotFound;	
}
