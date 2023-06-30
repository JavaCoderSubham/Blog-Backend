package com.blog.review.repository;

import com.blog.review.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {

    List<Review> findByUserId(String userId);
    List<Review> findByBlogId(String blogId);
    List<Review> findByUserName(String userName);
    List<Review> findByRating(Integer rating);

}
