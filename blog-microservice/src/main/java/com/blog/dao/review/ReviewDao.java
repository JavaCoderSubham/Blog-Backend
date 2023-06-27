package com.blog.dao.review;

import java.util.List;

import com.blog.entity.Review;

public interface ReviewDao {

    Review getReview(String id);
    List<Review> getPostIdReview(String postId);
    Review create(String postId, Review review);
    void delete(String id);
    Review findByMobile(String mobileNumber);

}
