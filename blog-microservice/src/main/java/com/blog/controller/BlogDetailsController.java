package com.blog.controller;

import com.blog.entity.BlogDetails;
import com.blog.service.BlogDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/blog")
public class BlogDetailsController {

    private final BlogDetailsService service;

    public BlogDetailsController(BlogDetailsService service) {
        this.service = service;
    }

//    ================= Get Methods =================
    @GetMapping("/getAll")
    public List<BlogDetails> getAll() {
        log.info("============ Get All Method Start ============");
        log.info("getAll() -> | ");
        List<BlogDetails> all = service.getAll();
        log.info("getAll() -> | List BlogDetails : {}",all);
        log.info("============ Get All Method End ============");
        return all;
    }

    @GetMapping("/get/{id}")
    public BlogDetails getBlog(@PathVariable String id) {
        log.info("============ Get By ID Method Start ============");
        log.info("getBlog(String) -> | Id : {}",id);
        BlogDetails blog = service.getBlog(id);
        log.info("getBlog(String) -> | BlogDetails : {}",blog);
        log.info("============ Get By ID Method End ============");
        return blog;
    }

//    ================= Create Methods =================
    @PostMapping("/create")
    public BlogDetails create(@RequestBody BlogDetails blogDetails) {
        log.info("============ Create Method Start ============");
        log.info("create(BlogDetails) -> | BlogDetails : {}",blogDetails);
        BlogDetails save = service.create(blogDetails);
        log.info("create(BlogDetails) -> | After save BlogDetails : {}",save);
        log.info("============ Create Method End ============");
        return save;
    }

//    ================= Update Methods =================
    @PutMapping("/update/{id}")
    public BlogDetails update(@PathVariable String id,@RequestBody BlogDetails blogDetails) {
        log.info("============ Update Method Start ============");
        log.info("update(String,BlogDetails) -> | Id : {} | BlogDetails : {}",id,blogDetails);
        BlogDetails save = service.update(id,blogDetails);
        log.info("update(String,BlogDetails) -> | After Save : {}",save);
        log.info("============ Update Method End ============");
        return save;
    }

//    ================= Delete Methods =================
    @DeleteMapping("/delete/{id}")
    public void blogDeleteById(@RequestParam String id) {
        log.info("============ Blog Delete By Id Method Start ============");
        log.info("blogDeleteById(String) -> | Id : {}",id);
        service.blogDeleteById(id);
        log.info("blogDeleteById(String) -> | Id : {} | Completed",id);
        log.info("============ Blog Delete By Id Method End ============");
    }

    @DeleteMapping("/deleteAll")
    public void blogDeleteAll() {
        log.info("============ Delete All Method Start ============");
        log.info("blogDeleteAll() -> | ");
        service.blogDeleteAll();
        log.info("blogDeleteAll() -> | Completed");
        log.info("============ Delete All Method End ============");
    }

//    ================= Find Methods =================

    @GetMapping("/findAuthor/{author}")
    public List<BlogDetails> findByAuthor(@PathVariable String author) {
        log.info("============ Find By Author Method Start ============");
        log.info("findByAuthor(String) -> | Author : {}",author);
        List<BlogDetails> list = service.findByAuthor(author);
        log.info("findByAuthor(String) -> | List Author BlogDetails : {}",list);
        log.info("============ Find By Author Method End ============");
        return list;
    }

    @GetMapping("/findTitle/{title}")
    public List<BlogDetails> findByTitleStartingWith(@PathVariable String title) {
        log.info("============ Find By Title StartWith Method Start ============");
        log.info("findByTitleStartingWith(String) -> | Title : {}",title);
        List<BlogDetails> list = service.findByTitleStartingWith(title);
        log.info("findByTitleStartingWith(String) -> | List Title BlogDetails : {}",list);
        log.info("============ Find By Title StartWith Method End ============");
        return list;
    }

    @GetMapping("/findTopic/{topic}")
    public List<BlogDetails> findByTopicStartingWith(@PathVariable String topic) {
        log.info("============ Find By Topic StartWith Method Start ============");
        log.info("findByTopicStartingWith(String) -> | Topic : {}",topic);
        List<BlogDetails> list = service.findByTopicStartingWith(topic);
        log.info("findByTopicStartingWith(String) -> | List Topic BlogDetails : {}",list);
        log.info("============ Find By Topic StartWith Method End ============");
        return list;
    }

    @GetMapping("/findEmail/{email}")
    public List<BlogDetails> findByEmail(@PathVariable String email) {
        log.info("============ Find By Email Method Start ============");
        log.info("findByEmail(String) -> | Email : {}",email);
        List<BlogDetails> list = service.findByEmail(email);
        log.info("findByEmail(String) -> | List Email BlogDetails : {}",list);
        log.info("============ Find By Email Method End ============");
        return list;
    }

    @GetMapping("/findBlogText/{blogText}")
    public List<BlogDetails> findByBlogTextContaining(@PathVariable String blogText) {
        log.info("============ Find By BlogText StartingWith Method Start ============");
        log.info("findByBlogTextStartingWith(String) -> | BlogText : {}",blogText);
        List<BlogDetails> list = service.findByBlogTextContaining(blogText);
        log.info("findByBlogTextStartingWith(String) -> | List BlogText BlogDetails : {}",list);
        log.info("============ Find By BlogText StartingWith Method End ============");
        return list;
    }

}
