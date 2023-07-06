package com.blog.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blog.entity.BlogDetails;

public interface BlogDetailsRepository extends MongoRepository<BlogDetails, String> {

//    ================= Find Methods =================
    List<BlogDetails> findByAuthor(String author);
    List<BlogDetails> findByTitleStartingWith(String title);
    List<BlogDetails> findByTopicStartingWith(String topic);
    List<BlogDetails> findByEmail(String email);
    List<BlogDetails> findByBlogTextContaining(String blogText);


}
