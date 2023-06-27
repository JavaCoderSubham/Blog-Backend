package com.blog.userInfo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blog.userInfo.entity.UserDetails;



public interface UserRepository extends MongoRepository<UserDetails, Integer>{
	

}
