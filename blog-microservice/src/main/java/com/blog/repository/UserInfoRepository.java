package com.blog.repository;

import com.blog.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserInfoRepository extends MongoRepository<UserInfo,String> {

    Optional<UserInfo> findByMobileNumber(String number);


}
