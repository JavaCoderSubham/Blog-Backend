package com.blog.subscribe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blog.subscribe.entity.Subscribe;

public interface SubScribeRepository extends MongoRepository<Subscribe,String> {
    List<Subscribe> findByActiveSubscribeTrue();
    List<Subscribe> findByActiveSubscribeFalse();
    Optional<Subscribe> findSubscribeByEmail(String email);
    void deleteSubscribeByEmail(String email);
	Optional<Subscribe> findSubscribeByMobileNumber(String mobileNumber);
}
