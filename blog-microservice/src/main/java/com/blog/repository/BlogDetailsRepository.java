package com.blog.repository;

import com.blog.entity.BlogDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BlogDetailsRepository extends MongoRepository<BlogDetails, String> {

    List<BlogDetails> findByAuthor(String author);
    List<BlogDetails> findByTitleStartingWith(String title);
    List<BlogDetails> findByTopicStartingWith(String topic);
    List<BlogDetails> findByEmail(String email);
    List<BlogDetails> findByBlogTextStartingWith(String blogText);


}
