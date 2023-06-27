package com.blog.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blog.entity.Review;

public interface ReviewRepository extends MongoRepository<Review,String> {
    List<Review> findByPostId(String postId);

}
