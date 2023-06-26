package com.blog.repository;

import com.blog.entity.Subscribe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SubScribeRepository extends MongoRepository<Subscribe,String> {
    List<Subscribe> findByActiveSubscribeTrue();
    List<Subscribe> findByActiveSubscribeFalse();
    Optional<Subscribe> findSubscribeByEmail(String email);
}
