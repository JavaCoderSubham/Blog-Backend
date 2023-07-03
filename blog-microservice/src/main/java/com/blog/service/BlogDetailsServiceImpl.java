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

//    Constructor
    public BlogDetailsServiceImpl(BlogDetailsDao dao) {
        this.dao = dao;
    }

//    Get
    @Override
    public List<BlogDetails> getAll() {
        log.info("getAll() -> | ");
        List<BlogDetails> all = dao.getAllBlog();
        log.info("getAll() -> | List BlogDetails : {}",all);
        return all;
    }
    @Override
    public BlogDetails getBlog(String id) {
        log.info("getBlog(String) -> | Id : {}",id);
        BlogDetails blog = dao.getBlog(id);
        log.info("getBlog(String) -> | BlogDetails : {}",blog);
        return blog;
    }

//    Create
    @Override
    public BlogDetails create(BlogDetails blogDetails) {
        log.info("create(BlogDetails) -> | BlogDetails : {}",blogDetails);
        blogDetails.setId(UUID.randomUUID().toString());
        log.info("create(BlogDetails) -> | Set Id : {}",blogDetails);
        BlogDetails getSave = dao.create(blogDetails);
        log.info("create(BlogDetails) -> | After execute Dao Create : {}",getSave);
        return getSave;
    }

//    Update
    @Override
    public BlogDetails update(String id, BlogDetails blogDetails) {
        log.info("update(String,BlogDetails) -> | Id : {} | BlogDetails : {}",id,blogDetails);
        BlogDetails update = dao.update(id, blogDetails);
        log.info("update(String,BlogDetails) -> | Update BlogDetails : {}",update);
        return update;
    }


//    Delete
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

//    Find
    @Override
    public List<BlogDetails> findByAuthor(String author) {
        log.info("findByAuthor(String) -> | Author : {}",author);
        List<BlogDetails> authorObject = dao.findByAuthor(author);
        log.info("findByAuthor(String) -> | Author List BlogDetails : {}",authorObject);
        return authorObject;
    }

    @Override
    public List<BlogDetails> findByTitleStartingWith(String title) {
        log.info("findByTitleStartingWith(String) -> | Title : {}",title);
        List<BlogDetails> titleObjects = dao.findByTitleStartingWith(title);
        log.info("findByTitleStartingWith(String) -> | Title List BlogDetails : {}",titleObjects);
        return titleObjects;
    }

    @Override
    public List<BlogDetails> findByTopicStartingWith(String topic) {
        log.info("findByTopicStartingWith(String) -> | Topic : {}",topic);
        List<BlogDetails> topicObjects = dao.findByTopicStartingWith(topic);
        log.info("findByTopicStartingWith(String) -> | Topic List BlogDetails : {}",topicObjects);
        return topicObjects;
    }

    @Override
    public List<BlogDetails> findByEmail(String email) {
        log.info("findByEmail(String) -> | Email : {}",email);
        List<BlogDetails> emailObjects = dao.findByEmail(email);
        log.info("findByEmail(String) -> | Email List BlogDetails : {}",emailObjects);
        return emailObjects;
    }

    @Override
    public List<BlogDetails> findByBlogTextStartingWith(String blogText) {
        log.info("findByBlogTextStartingWith(String) -> | BlogText : {}",blogText);
        List<BlogDetails> blogTextObjects = dao.findByBlogTextStartingWith(blogText);
        log.info("findByBlogTextStartingWith(String) -> |  : {}",blogText);
        return blogTextObjects;
    }


}



