package com.blog.dao.blogDetails;

import java.util.List;

import com.blog.entity.BlogDetails;

public interface BlogDetailsDao {

    List<BlogDetails> getAllBlog();
    BlogDetails getBlog(String id);
    BlogDetails create(BlogDetails blogDetails);
    BlogDetails update(String id, BlogDetails blogDetails);
    void delete(String id);
    void deleteAll();


//    Finding Method

    List<BlogDetails> findByAuthor(String author);
    List<BlogDetails> findByTitleStartingWith(String title);
    List<BlogDetails> findByTopicStartingWith(String topic);
    List<BlogDetails> findByEmail(String email);
    List<BlogDetails> findByBlogTextStartingWith(String blogText);

}



