package com.blog.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.blog.entity.Review;
import org.springframework.stereotype.Service;

import com.blog.dao.blogDetails.BlogDetailsDao;
import com.blog.entity.BlogDetails;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;


@Slf4j
@Service
public class BlogDetailsServiceImpl implements BlogDetailsService {

    private final BlogDetailsDao dao;

    private final String baseUrlReview = "http://localhost:8030/review";

    private final WebClient webClient;

//    ================= Constructor =================
    public BlogDetailsServiceImpl(BlogDetailsDao dao, WebClient webClient) {
        this.dao = dao;
        this.webClient = webClient;
    }
//    ================= Get Method =================
    @Override
    public List<BlogDetails> getAll() {
        log.info("getAll() -> | ");
        List<BlogDetails> all = dao.getAllBlog();
        log.info("getAll() -> | List BlogDetails : {}",all);
        log.info("getAllBlog() -> | Set All Reviews ");
        for(BlogDetails blog : all) {

            Review[] review = webClient.get()
                    .uri(baseUrlReview+"/findByBlogId/"+blog.getId())
                    .retrieve()
                    .bodyToMono(Review[].class)
                    .block();

            blog.setReview(Arrays.asList(review));
        }

        log.info("getAllBlog() -> | After Reviews Set : {}",all);
        return all;
    }
    @Override
    public BlogDetails getBlog(String id) {
        log.info("getBlog(String) -> | Id : {}",id);
        BlogDetails blog = dao.getBlog(id);
        log.info("getBlog(String) -> | BlogDetails : {}",blog);
        Review[] review = webClient.get()
                .uri(baseUrlReview+"/findByBlogId/"+id)
                .retrieve()
                .bodyToMono(Review[].class)
                .block();
        log.info("etBlog(String) -> | Review : {}",review);
        blog.setReview(Arrays.asList(review));
        log.info("etBlog(String) -> | After Review Set : {}",blog);
        return blog;
    }

//    ================= Create Methods =================
    @Override
    public BlogDetails create(BlogDetails blogDetails) {
        log.info("create(BlogDetails) -> | BlogDetails : {}",blogDetails);
        blogDetails.setId(UUID.randomUUID().toString());
        log.info("create(BlogDetails) -> | Set Id : {}",blogDetails);
        BlogDetails getSave = dao.create(blogDetails);
        log.info("create(BlogDetails) -> | After execute Dao Create : {}",getSave);
        return getSave;
    }

//    ================= Update Methods =================
    @Override
    public BlogDetails update(String id, BlogDetails blogDetails) {
        log.info("update(String,BlogDetails) -> | Id : {} | BlogDetails : {}",id,blogDetails);
        BlogDetails update = dao.update(id, blogDetails);
        log.info("update(String,BlogDetails) -> | Update BlogDetails : {}",update);
        return update;
    }


//    ================= Delete Methods =================
    @Override
    public void blogDeleteById(String id) {
        log.info("blogDeleteById(String) -> | Id : {}",id);
        dao.delete(id);
        log.info("blogDeleteById(String) -> | Id : {} | Deleted",id);
    }

    @Override
    public void blogDeleteAll() {
        log.info("blogDeleteAll() -> | ");
        dao.deleteAll();
        log.info("blogDeleteAll() -> | All delete");
    }

//    ================= Find Methods =================
    @Override
    public List<BlogDetails> findByAuthor(String author) {
        log.info("findByAuthor(String) -> | Author : {}",author);
        List<BlogDetails> authorObject = dao.findByAuthor(author);
        log.info("findByAuthor(String) -> | Author List BlogDetails : {}",authorObject);
        for(BlogDetails blog : authorObject) {
            Review[] review = webClient.get()
                    .uri(baseUrlReview+"/findByBlogId/"+blog.getId())
                    .retrieve()
                    .bodyToMono(Review[].class)
                    .block();
            blog.setReview(Arrays.asList(review));
        }
        log.info("findByAuthor(String) -> | After Review : {}",authorObject);
        return authorObject;
    }

    @Override
    public List<BlogDetails> findByTitleStartingWith(String title) {
        log.info("findByTitleStartingWith(String) -> | Title : {}",title);
        List<BlogDetails> titleObjects = dao.findByTitleStartingWith(title);
        log.info("findByTitleStartingWith(String) -> | Title List BlogDetails : {}",titleObjects);
        for(BlogDetails blog : titleObjects) {
            Review[] review = webClient.get()
                    .uri(baseUrlReview+"/findByBlogId/"+blog.getId())
                    .retrieve()
                    .bodyToMono(Review[].class)
                    .block();
            blog.setReview(Arrays.asList(review));
        }
        log.info("findByTitleStartingWith(String) -> | After Set Review : {}",titleObjects);
        return titleObjects;
    }

    @Override
    public List<BlogDetails> findByTopicStartingWith(String topic) {
        log.info("findByTopicStartingWith(String) -> | Topic : {}",topic);
        List<BlogDetails> topicObjects = dao.findByTopicStartingWith(topic);
        log.info("findByTopicStartingWith(String) -> | Topic List BlogDetails : {}",topicObjects);
        for(BlogDetails blog : topicObjects) {
            Review[] review = webClient.get()
                    .uri(baseUrlReview+"/findByBlogId/"+blog.getId())
                    .retrieve()
                    .bodyToMono(Review[].class)
                    .block();
            blog.setReview(Arrays.asList(review));
        }
        log.info("findByTopicStartingWith(String) -> | After Set Review : {}",topicObjects);
        return topicObjects;
    }

    @Override
    public List<BlogDetails> findByEmail(String email) {
        log.info("findByEmail(String) -> | Email : {}",email);
        List<BlogDetails> emailObjects = dao.findByEmail(email);
        log.info("findByEmail(String) -> | Email List BlogDetails : {}",emailObjects);
        for(BlogDetails blog : emailObjects) {
            Review[] review = webClient.get()
                    .uri(baseUrlReview+"/findByBlogId/"+blog.getId())
                    .retrieve()
                    .bodyToMono(Review[].class)
                    .block();
            blog.setReview(Arrays.asList(review));
        }
        log.info("findByEmail(String) -> | After Set Review : {}",emailObjects);
        return emailObjects;
    }

    @Override
    public List<BlogDetails> findByBlogTextContaining(String blogText) {
        log.info("findByBlogTextStartingWith(String) -> | BlogText : {}",blogText);
        List<BlogDetails> blogTextObjects = dao.findByBlogTextContaining(blogText);
        log.info("findByBlogTextStartingWith(String) -> |  : {}",blogText);
        for(BlogDetails blog : blogTextObjects) {
            Review[] review = webClient.get()
                    .uri(baseUrlReview+"/findByBlogId/"+blog.getId())
                    .retrieve()
                    .bodyToMono(Review[].class)
                    .block();
            blog.setReview(Arrays.asList(review));
        }
        log.info("findByBlogTextStartingWith(String) -> | After Set Review : {}",blogTextObjects);
        return blogTextObjects;
    }


}



