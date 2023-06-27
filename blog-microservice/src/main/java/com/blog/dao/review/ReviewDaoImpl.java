package com.blog.dao.review;

import com.blog.entity.Review;
import com.blog.exception.ReviewNotFoundException;
import com.blog.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public Review create(Review review) {
        log.info("create(Review) -> | Review : {}",review);



        review.setId(UUID.randomUUID().toString());
        log.info("create(Review) -> | Set UUID : {}",review);
        Review save = repository.save(review);
        log.info("create(Review) -> | After Save Review : {}",save);
        return save;
    }
    @Override
    public void delete(String id) {
        log.info("delete(String) -> | Id : {}",id);
        getReview(id);
        log.info("delete(String) -> | Id : {} | Present",id);
        repository.deleteById(id);
        log.info("delete(String) -> | Deleted Id : {}",id);
    }


}




