package com.blog.dao.blogDetails;

import com.blog.entity.BlogDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BlogDetailsDao {

//    Get
    List<BlogDetails> getAllBlog();
    BlogDetails getBlog(String id);

//    Create
    BlogDetails create(BlogDetails blogDetails);

//    Update
    BlogDetails update(String id, BlogDetails blogDetails);

//    Delete
    void delete(String id);
    void deleteAll();


//    Finding

    List<BlogDetails> findByAuthor(String author);
    List<BlogDetails> findByTitleStartingWith(String title);
    List<BlogDetails> findByTopicStartingWith(String topic);
    List<BlogDetails> findByEmail(String email);
    List<BlogDetails> findByBlogTextStartingWith(String blogText);

}



