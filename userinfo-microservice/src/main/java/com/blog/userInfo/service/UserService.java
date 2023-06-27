package com.blog.userInfo.service;

import java.util.List;

import com.blog.userInfo.entity.UserDetails;
import com.blog.userInfo.exception.NotFound;



public interface UserService {

	UserDetails create(UserDetails user);
	List<UserDetails> getAll();
	UserDetails getById(int id);
	String deleteById(int id) throws NotFound;
	
}
