package com.blog.userInfo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blog.userInfo.dto.UserInfoDto;
import com.blog.userInfo.entity.UserInfo;
import com.blog.userInfo.entity.UserProjectionEmail;


public interface UserRepository extends MongoRepository<UserInfo, String>{
	
	
	List<UserInfo> findByName(String name);
	
	List<UserInfo> findByAddressCity(String city);
	
	List<UserInfo> findByAddressState(String state);

//	UserProjectionEmail getUserByEmail(String email,Class<UserProjectionEmail> projectionType);
	
	Optional<UserInfo> findByEmail(String email);
	
	Optional<UserInfo> findByPhoneNo(String phoneNo);

	
}
