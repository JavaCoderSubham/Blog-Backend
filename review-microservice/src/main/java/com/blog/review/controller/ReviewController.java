package com.blog.review.controller;


import com.blog.review.entity.Review;
import com.blog.review.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        log.info("ReviewController(ReviewService) -> | Object Created...");
        this.service = service;
    }

    public List<Review> getReviewsUserId(String id) {
        log.info("================= Get Reviews UserId Start =================");
        log.info("getReviewsUserId(String) -> | Id : {}",id);
        log.info("================= Get Reviews UserId End =================");
        return null;
    }
    public Review getReviewId(String id) {
        log.info("================= Get Reviews Id Start =================");
        log.info("================= Get Reviews Id End =================");
        return null;
    }
    public List<Review> getReviewBlogId(String id) {
        log.info("================= Get Reviews BlogId Start =================");
        log.info("================= Get Reviews BlogId End =================");
        return null;
    }
    public Review createReview(Review review) {
        log.info("================= Create Review Start =================");
        log.info("================= Create Review End =================");
        return null;
    }
    public Review updateReview(String id,Review review) {
        log.info("================= Update Review Start =================");
        log.info("================= Update Review End =================");
        return null;
    }
    public Map<String,String> deleteById(String id) {
        log.info("================= Delete By Id Start =================");
        log.info("================= Delete By Id End =================");
        return null;
    }

//    ==================== Find Methods ====================

    public List<Review> findByUserId(String userId) {
        log.info("================= Find By User Id Start =================");
        log.info("================= Find By User Id End =================");
        return null;
    }

    public List<Review> findByBlogId(String blogId) {
        log.info("================= Find By Blog Id Start =================");
        log.info("================= Find By Blog Id End =================");
        return null;
    }

    public List<Review> findByUserName(String userName) {
        log.info("================= Find By User Name Start =================");
        log.info("================= Find By User Name End =================");
        return null;
    }

    public List<Review> findByRating(Integer rating) {
        log.info("================= Find By Rating Start =================");
        log.info("================= Find By Rating End =================");
        return null;
    }

    public Review findByUserIdAndBlogId(String userId, String BlogId) {
        log.info("================= Find By UserId And BlogId Start =================");
        log.info("================= Find By UserId And BlogId End =================");
        return null;
    }

    public Review findByUserIdAndId(String userId, String id) {
        log.info("================= Find By UserId And Id Start =================");
        log.info("================= Find By UserId And Id End =================");
        return null;
    }

    public Review findByBlogIdAndId(String blogId, String id) {
        log.info("================= Find By BlogId And Id Start =================");
        log.info("================= Find By BlogId And Id End =================");
        return null;
    }

}
