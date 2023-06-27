package com.blog.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.blog.dao.blogDetails.BlogDetailsDao;
import com.blog.entity.BlogDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BlogDetailsServiceImpl implements BlogDetailsService {

    private final BlogDetailsDao dao;

    public BlogDetailsServiceImpl(BlogDetailsDao dao) {
        this.dao = dao;
    }

    @Override
    public BlogDetails create(BlogDetails blogDetails) {
        log.info("create(BlogDetails) -> | BlogDetails : {}",blogDetails);
        blogDetails.setId(UUID.randomUUID().toString());
        log.info("create(BlogDetails) -> | Set Id : {}",blogDetails);
        BlogDetails getSave = dao.create(blogDetails);
        log.info("create(BlogDetails) -> | After execute Dao Create : {}",getSave);
        return getSave;
    }

    @Override
    public List<BlogDetails> getAll() {
        log.info("getAll() -> | ");
        List<BlogDetails> all = dao.getAllBlog();
        log.info("getAll() -> | List BlogDetails : {}",all);
        return all;
    }

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


}



