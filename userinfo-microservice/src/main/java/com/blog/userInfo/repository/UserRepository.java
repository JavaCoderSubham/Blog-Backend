package com.blog.userInfo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.blog.userInfo.entity.UserInfo;


public interface UserRepository extends MongoRepository<UserInfo, String>{
	
	
	List<UserInfo> findByName(String name);
	
//	List<UserInfo> findByCity(String city);
//	
//	List<UserInfo> findByState(String state);
	
	Optional<UserInfo> findByEmail(String email);
	
	UserInfo findByPhoneNo(String phoneNo);

}
