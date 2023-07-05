package com.blog.review.service;

import com.blog.review.entity.Review;

import java.util.List;
import java.util.Map;

public interface ReviewService {

    Review getReviewId(String id);
    Review createReview(Review review);
    Review updateReview(String id,Review review);
    Map<String,String> deleteById(String id);

    // =================== Find Methods ================

    List<Review> findByUserId(String userId);
    List<Review> findByBlogId(String blogId);
    List<Review> findByUserName(String userName);
    List<Review> findByRating(Integer rating);
    Review findByUserIdAndBlogId(String userId,String BlogId);
    Review findByUserIdAndId(String userId, String id);
    Review findByBlogIdAndId(String blogId, String id);

    Map<String,String> deleteByBlogId(String id);
    Map<String,String> deleteByUserId(String id);

}
