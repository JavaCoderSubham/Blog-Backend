package com.blog.service;

import java.util.List;

import com.blog.entity.BlogDetails;

public interface BlogDetailsService {

//    Get
    List<BlogDetails> getAll();
    BlogDetails getBlog(String id);

//    Create
    BlogDetails create (BlogDetails blogDetails);

//    Update
    BlogDetails update(String id, BlogDetails blogDetails);

//    Delete
    void blogDeleteById(String id);
    void blogDeleteAll();


    //    Finding
    List<BlogDetails> findByAuthor(String author);
    List<BlogDetails> findByTitleStartingWith(String title);
    List<BlogDetails> findByTopicStartingWith(String topic);
    List<BlogDetails> findByEmail(String email);
    List<BlogDetails> findByBlogTextContaining(String blogText);

}
