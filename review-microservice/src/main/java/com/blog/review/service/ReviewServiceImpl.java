package com.blog.review.service;

import com.blog.review.entity.Review;
import com.blog.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;

    public ReviewServiceImpl(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Review> getReviewsUserId(String id) {
        List<Review> userIdValue = repository.findByUserId(id);
        return userIdValue;
    }

    @Override
    public List<Review> getReviewId(String id) {
        return null;
    }

    @Override
    public List<Review> getReviewBlogId(String id) {
        return null;
    }

    @Override
    public Review createReview(Review review) {
        return null;
    }

    @Override
    public Review updateReview(String id, Review review) {
        return null;
    }

    @Override
    public Map<String, String> deleteById(String id) {
        return null;
    }

    @Override
    public Map<String, String> deleteByUserId(String userId) {
        return null;
    }

//    =================== Find Method ===================

    @Override
    public List<Review> findByUserId(String userId) {
        return null;
    }

    @Override
    public List<Review> findByBlogId(String blogId) {
        return null;
    }

    @Override
    public List<Review> findByUserName(String userName) {
        return null;
    }

    @Override
    public List<Review> findByRating(Integer rating) {
        return null;
    }

    @Override
    public Review findByUserIdAndBlogId(String userId, String BlogId) {
        return null;
    }

    @Override
    public Review findByUserIdAndId(String userId, String id) {
        return null;
    }

    @Override
    public Review findByBlogIdAndId(String blogId, String id) {
        return null;
    }
}
