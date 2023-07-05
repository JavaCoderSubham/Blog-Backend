package com.blog.review.controller;


import com.blog.review.entity.Review;
import com.blog.review.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getReviewById/{id}")
    public Review getReviewId(@PathVariable String id) {
        log.info("================= Get Reviews Id Start =================");
        log.info("getReviewId(String) -> | Id : {}",id);
        Review reviewId = service.getReviewId(id);
        log.info("getReviewId(String) -> | Review : {}",reviewId);
        log.info("================= Get Reviews Id End =================");
        return reviewId;
    }

    @PostMapping("/create")
    public Review createReview( @RequestBody Review review) {
        log.info("================= Create Review Start =================");
        log.info("createReview(Review) -> | Review : {}",review);
        Review save = service.createReview(review);
        log.info("createReview(Review) -> | After Save Review : {}",save);
        log.info("================= Create Review End =================");
        return save;
    }

    @PutMapping("/update/{id}")
    public Review updateReview(@PathVariable String id,@RequestBody Review review) {
        log.info("================= Update Review Start =================");
        log.info("updateReview(String,Review) -> | Id : {} | Review : {}",id,review);
        Review save = service.updateReview(id, review);
        log.info("updateReview(String,Review) -> | ");
        log.info("================= Update Review End =================");
        return save;
    }

    @DeleteMapping("/deleteById/{id}")
    public Map<String,String> deleteById(@PathVariable String id) {
        log.info("================= Delete By Id Start =================");
        log.info("deleteById(String) -> | Id : {}",id);
        Map<String, String> reviewDelete = service.deleteById(id);
        log.info("deleteById(String) -> | Review Message : {}",reviewDelete);
        log.info("================= Delete By Id End =================");
        return reviewDelete;
    }

//    ==================== Find Methods ====================

    @GetMapping("/findByUserId/{userId}")
    public List<Review> findByUserId(@PathVariable String userId) {
        log.info("================= Find By User Id Start =================");
        log.info("findByUserId(String) -> | UserId : {}",userId);
        List<Review> list = service.findByUserId(userId);
        log.info("findByUserId(String) -> | List UserId Review : {}",list);
        log.info("================= Find By User Id End =================");
        return list;
    }

    @GetMapping("/findByBlogId/{blogId}")
    public List<Review> findByBlogId(@PathVariable String blogId) {
        log.info("================= Find By Blog Id Start =================");
        log.info("findByBlogId(String) -> | BlogId : {}",blogId);
        List<Review> blog = service.findByBlogId(blogId);
        log.info("findByBlogId(String) -> | List Review Blog : {}",blog);
        log.info("================= Find By Blog Id End =================");
        return blog;
    }

    @GetMapping("/findByUserName/{userName}")
    public List<Review> findByUserName(@PathVariable String userName) {
        log.info("================= Find By User Name Start =================");
        log.info("findByUserName(String) -> | UserName : {}",userName);
        List<Review> userNameBlog = service.findByUserName(userName);
        log.info("findByUserName(String) -> | List Username Review : {}",userNameBlog);
        log.info("================= Find By User Name End =================");
        return userNameBlog;
    }

    @GetMapping("/findByRating/{rating}")
    public List<Review> findByRating(@PathVariable Integer rating) {
        log.info("================= Find By Rating Start =================");
        log.info("findByRating(Integer) -> | Rating : {}",rating);
        List<Review> blog = service.findByRating(rating);
        log.info("findByRating(Integer) -> | List Rating Blog : {}",blog);
        log.info("================= Find By Rating End =================");
        return blog;
    }

    @GetMapping("/findByUserIdAndBlogId/{userId}/{blogId}")
    public Review findByUserIdAndBlogId(@PathVariable String userId,@PathVariable String blogId) {
        log.info("================= Find By UserId And BlogId Start =================");
        log.info("findByUserIdAndBlogId(String,String) -> | UserId : {} | BlogId : {}",userId,blogId);
        Review reviewUserAndBlog = service.findByUserIdAndBlogId(userId, blogId);
        log.info("findByUserIdAndBlogId(String,String) -> | Review : {}",reviewUserAndBlog);
        log.info("================= Find By UserId And BlogId End =================");
        return reviewUserAndBlog;
    }

    @GetMapping("/findByUserIdAndId/{userId}/{id}")
    public Review findByUserIdAndId(@PathVariable String userId,@PathVariable String id) {
        log.info("================= Find By UserId And Id Start =================");
        log.info("findByUserIdAndId(String,String) -> | UserId : {} | Id : {}",userId,id);
        Review review = service.findByUserIdAndId(userId, id);
        log.info("findByUserIdAndId(String,String) -> | Review : {}",review);
        log.info("================= Find By UserId And Id End =================");
        return review;
    }

    @GetMapping("/findByBlogIdAndId/{blogId}/{id}")
    public Review findByBlogIdAndId(@PathVariable String blogId,@PathVariable String id) {
        log.info("================= Find By BlogId And Id Start =================");
        log.info("findByBlogIdAndId(String,String) -> | BlogId : {} | Id : {}",blogId,id);
        Review review = service.findByBlogIdAndId(blogId, id);
        log.info("findByBlogIdAndId(String,String) -> | Review : {}",review);
        log.info("================= Find By BlogId And Id End =================");
        return review;
    }

    @DeleteMapping("/deleteByBlogId/{blogId}")
    public Map<String,String> deleteByBlogId(@PathVariable String blogId) {
        log.info("================= Delete By BlogId Start =================");
        log.info("deleteByBlogId(String) -> | BlogId : {}",blogId);
        Map<String, String> delete = service.deleteByBlogId(blogId);
        log.info("deleteByBlogId(String) -> | Delete Message : {}",delete);
        log.info("================= Delete By BlogId End =================");
        return delete;
    }


}
