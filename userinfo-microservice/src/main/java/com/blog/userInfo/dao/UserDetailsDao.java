package com.blog.userInfo.dao;

import java.util.List;

import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.blog.userInfo.dto.UserInfoDto;
import com.blog.userInfo.entity.UserInfo;
import com.blog.userInfo.entity.UserProjectionEmail;
import com.blog.userInfo.entity.UserProjectionPhoneNo;
import com.blog.userInfo.exception.RecordNotFound;


public interface UserDetailsDao {

	UserInfo create(UserInfo user);
	List<UserInfoDto> getAll();
	UserInfoDto getById(String id) throws NotFound, RecordNotFound;
	String deleteById(String id) throws NotFound, RecordNotFound;
	UserInfo update(UserInfo userDetails , String id);
	
	//***************************************//
	
	List<UserInfoDto> findByName(String name) throws RecordNotFound;
	
	List<UserInfoDto> findByAddressCity(String city) throws RecordNotFound;
	
	List<UserInfoDto> findByAddressState(String state) throws RecordNotFound;
	
	void changePassword(String email, String password) throws RecordNotFound;
	
	UserProjectionEmail findByEmail(String email) throws RecordNotFound;
	
	UserProjectionPhoneNo findByPhoneNo(String phoneNo) throws  RecordNotFound;
	
	public boolean emailOrPhoneNoExist(UserInfo userInfo);
}
