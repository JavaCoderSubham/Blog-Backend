package com.blog.review.service;

import com.blog.review.entity.Review;
import com.blog.review.exception.BlogIdNotFoundException;
import com.blog.review.exception.ReviewIdNotFoundException;
import com.blog.review.exception.UserIdIsAlreadyPresentException;
import com.blog.review.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;

    public ReviewServiceImpl(ReviewRepository repository) {
        log.info("ReviewServiceImpl(ReviewRepository) -> | ReviewRepository : {}",repository);
        this.repository = repository;
    }

    @Override
    public Review getReviewId(String id) {
        log.info("getReviewId(String) -> | Id : {}",id);
        Review review = repository.findById(id).orElseThrow(() -> new ReviewIdNotFoundException(id));
        log.info("getReviewId(String) -> | Review : {}",review);
        return review;
    }

//    ================= Create Method =================
    @Override
    public Review createReview(Review review) {
    	
        log.info("createReview(Review) -> | Review : {}",review);
//        Check UserId and BlogID if both are Present Review can't upload multiple time in 1 user
        if(findByUserIdAndBlogIdCheck(review.getUserId(), review.getBlogId())) {
            log.error("createReview(Review) -> | Review Already Present for UserId : {}",review.getUserId());
            throw new UserIdIsAlreadyPresentException(review.getUserId());
        }
        review.setId(UUID.randomUUID().toString());
        log.info("createReview(Review) -> | Review Set Id : {}",review);
        Review save = repository.save(review);
        log.info("createReview(Review) -> | After Save : {}",save);
        return save;
    }

    @Override
    public Review updateReview(String id, Review review) {
        log.info("updateReview(String,Review) -> | Id : {} | Review : {}",id,review);
        Review reviewId = getReviewId(id);
        log.info("updateReview(String,Review) -> | Review : {}",reviewId);
        reviewId.setRating(review.getRating());
        reviewId.setComment(review.getComment());
        log.info("updateReview(String,Review) -> | Review : {}",reviewId);
        Review save = repository.save(reviewId);
        log.info("updateReview(String,Review) -> | After Save : {}",save);
        return save;
    }

    @Override
    public Map<String, String> deleteById(String id) {
        log.info("deleteById(String) -> | Id : {}",id);
        getReviewId(id);
        log.info("deleteById(String) -> | Id : {} | Present...",id);
        repository.deleteById(id);
        Map<String,String> map = new HashMap<>();
        map.put("success","Delete Completed : "+id);
        return map;
    }


//    =================== Find Method ===================

    @Override
    public List<Review> findByUserId(String userId) {
        log.info("findByUserId(String) -> | UserId : {}",userId);
        List<Review> byUserId = repository.findByUserId(userId);
        log.info("findByUserId(String) -> | List UserID Review : {}",byUserId);
        return byUserId;
    }

    private boolean findByUserIdAndBlogIdCheck(String userId, String blogId) {
        log.info("findByUserIdAndBlogIdCheck(String,String) -> | UserID : {} | BlogId : {}",userId,blogId);
        Review review = repository.findByUserIdAndBlogId(userId,blogId)
                .orElse(null);
        log.info("findByUserIdAndBlogIdCheck(String,String) -> | Review : {}",review);
        return review != null;
    }

    @Override
    public List<Review> findByBlogId(String blogId) {
        log.info("findByBlogId(String) -> | BlogId : {}",blogId);
        List<Review> byBlogId = repository.findByBlogId(blogId);
        log.info("findByBlogId(String) -> | List BlogId Review : {}",byBlogId);
        return byBlogId;
    }

    @Override
    public List<Review> findByUserName(String userName) {
        log.info("findByUserName(String) -> | UserName : {}",userName);
        List<Review> userNameReview = repository.findByUserName(userName);
        log.info("findByUserName(String) -> | List UserName Review : {}",userNameReview);
        return userNameReview;
    }

    @Override
    public List<Review> findByRating(Integer rating) {
        log.info("findByRating(Integer) -> | Rating : {}",rating);
        List<Review> byRating = repository.findByRating(rating);
        log.info("findByRating(Integer) -> | List Rating Review : {}",byRating);
        return byRating;
    }

    @Override
    public Review findByUserIdAndBlogId(String userId, String BlogId) {
        log.info("findByUserIdAndBlogId(String,String) -> | UserId : {} | BlogId : {}",userId,BlogId);
        Review userIdAndBlogId = repository.findByUserIdAndBlogId(userId, BlogId)
                .orElseThrow();
        log.info("findByUserIdAndBlogId(String,String) -> | Review UserId And BlogId : {}",userIdAndBlogId);
        return userIdAndBlogId;
    }

    @Override
    public Review findByUserIdAndId(String userId, String id) {
        log.info("findByUserIdAndId(String,String) -> | UserId : {} | Id : {}",userId,id);
        Review byUserIdAndId = repository.findByUserIdAndId(userId, id)
                .orElseThrow();
        log.info("findByUserIdAndId(String,String) -> | Review : {}",byUserIdAndId);
        return byUserIdAndId;
    }

    @Override
    public Review findByBlogIdAndId(String blogId, String id) {
        log.info("findByBlogIdAndId(String,String) -> | BlogId : {} | Id : {}",blogId,id);
        Review byBlogIdAndId = repository.findByBlogIdAndId(blogId, id)
                .orElseThrow();
        log.info("findByBlogIdAndId(String,String) -> | Review : {}",byBlogIdAndId);
        return byBlogIdAndId;
    }

//    ============= Custom Delete Method =============

    @Override
    public Map<String,String> deleteByBlogId(String id) {
        log.info("deleteByBlogId(String) -> | Id : {}",id);
        List<Review> checkBlogId = repository.findByBlogId(id);
        if(checkBlogId == null) throw new BlogIdNotFoundException(id);
        log.info("deleteByBlogId(String) -> | Blog ID Present... | Check Blog Id : {}",checkBlogId);
        repository.deleteByBlogId(id);
        log.info("deleteByBlogId(String) -> | Delete Id : {}",id);
        Map<String,String> map = new HashMap<>();
        map.put("success","BlogId : "+id+" All Reviews are delete");
        return map;
    }

    @Override
    public Map<String,String> deleteByUserId(String id) {
        log.info("deleteByUserId(String) -> | Id : {}",id);
        List<Review> user = repository.findByUserId(id);
        if(user == null) throw new UserIdIsAlreadyPresentException(id);
        log.info("deleteByUserId(String) -> | User ID Present... | User ID : {}",user);
        repository.deleteByUserId(id);
        log.info("deleteByUserId(String) -> | User All Reviews are Deleted... | UserId : {}",id);
        Map<String,String> map = new HashMap<>();
        map.put("success","BlogId : "+id+" All Reviews are delete");
        return map;
    }

}
