package com.blog.userInfo.service;

import java.util.List;

import com.blog.userInfo.entity.UserDetails;
import com.blog.userInfo.exception.NotFound;



public interface UserService {

	UserDetails create(UserDetails user);
	List<UserDetails> getAll();
	UserDetails getById(int id) throws NotFound;
	String deleteById(int id) throws NotFound;
	UserDetails update(UserDetails userDetails , int id);
	
	//***************************************//
	
	List<UserDetails> findByName(String name) throws NotFound;
	
	List<UserDetails> findByCity(String city) throws NotFound;
	
	List<UserDetails> findByState(String state) throws NotFound;
	
	UserDetails findByEmail(String email) throws NotFound;
	
	UserDetails findByPhoneNo(long phoneNo) throws NotFound;
}
