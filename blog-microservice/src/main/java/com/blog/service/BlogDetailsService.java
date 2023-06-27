package com.blog.service;

import java.util.List;

import com.blog.entity.BlogDetails;

public interface BlogDetailsService {

    BlogDetails create (BlogDetails blogDetails);
    List<BlogDetails> getAll();
    void blogDeleteById(String id);
    void blogDeleteAll();

}
