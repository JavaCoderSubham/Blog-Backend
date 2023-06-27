package com.blog.dao.review;

import com.blog.entity.Review;

import java.util.List;

public interface ReviewDao {

    Review getReview(String id);
    List<Review> getPostIdReview(String postId);
    Review create(Review review);
    void delete(String id);

}
