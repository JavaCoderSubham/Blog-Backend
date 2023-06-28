package com.blog.userInfo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blog.userInfo.entity.UserDetails;



public interface UserRepository extends MongoRepository<UserDetails, Integer>{
	
	
	List<UserDetails> findByName(String name);
	
	List<UserDetails> findByCity(String city);
	
	List<UserDetails> findByState(String state);
	
	UserDetails findByEmail(String email);
	
	UserDetails findByPhoneNo(long phoneNo);

}
