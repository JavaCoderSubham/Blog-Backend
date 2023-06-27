package com.blog.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blog.entity.UserInfo;

public interface UserInfoRepository extends MongoRepository<UserInfo,String> {

    Optional<UserInfo> findByMobileNumber(String number);


}
