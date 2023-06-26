package com.blog.dao.review;

import com.blog.entity.Review;
import com.blog.exception.ReviewNotFoundException;
import com.blog.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Component
public class ReviewDaoImpl implements ReviewDao {

    private final ReviewRepository repository;

    public ReviewDaoImpl(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public Review getReview(String id) {
        log.info("getReview(String) -> | Id : {}",id);
        Review review = repository.findById(id).orElseThrow(ReviewNotFoundException::new);
        log.info("getReview(String) -> | Review : {}",review);
        return review;
    }

    @Override
    public List<Review> getPostIdReview(String postId) {
        log.info("getPostIdReview(String) -> | PostId : {}",postId);
        List<Review> listReview = repository.findByPostId(postId);
        log.info("getPostIdReview(String) -> | List Review : {}",listReview);
        return listReview;
    }
    @Override
    public Review create(String postId, Review review) {
//    TODO
        return null;
    }
    @Override
    public void delete(String id) {
//    TODO

    }
    @Override
    public Review findByMobile(String mobileNumber) {
//    TODO
        return null;
    }

}




