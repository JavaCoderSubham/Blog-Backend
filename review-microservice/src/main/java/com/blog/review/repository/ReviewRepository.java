package com.blog.review.repository;

import com.blog.review.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends MongoRepository<Review, String> {

    List<Review> findByUserId(String userId);
    List<Review> findByBlogId(String blogId);
    List<Review> findByUserName(String userName);
    List<Review> findByRating(Integer rating);
    Optional<Review> findByUserIdAndBlogId(String userId, String BlogId);
    Optional<Review> findByUserIdAndId(String userId, String id);
    Optional<Review> findByBlogIdAndId(String blogId, String id);

}
