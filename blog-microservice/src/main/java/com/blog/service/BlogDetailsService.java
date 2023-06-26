package com.blog.service;

import com.blog.entity.BlogDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BlogDetailsService {

    BlogDetails create (BlogDetails blogDetails);
    List<BlogDetails> getAll();
    void blogDeleteById(String id);
    void blogDeleteAll();

}
