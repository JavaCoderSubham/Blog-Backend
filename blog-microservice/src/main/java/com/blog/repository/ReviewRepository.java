package com.blog.repository;

import com.blog.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review,String> {
    List<Review> findByPostId(String postId);

}
