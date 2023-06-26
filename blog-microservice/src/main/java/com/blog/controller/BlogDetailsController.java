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

    @GetMapping("/getAll")
    public List<BlogDetails> getAll() {
        log.info("============ Get All Method Start ============");
        log.info("getAll() -> | ");
        List<BlogDetails> all = service.getAll();
        log.info("getAll() -> | List BlogDetails : {}",all);
        log.info("============ Get All Method End ============");
        return all;
    }

    @PostMapping("/create")
    public BlogDetails create(@RequestBody BlogDetails blogDetails) {
        log.info("create(BlogDetails) -> | BlogDetails : {}",blogDetails);
        BlogDetails save = service.create(blogDetails);
        log.info("create(BlogDetails) -> | After Service : {}",save);
        return save;
    }

    @DeleteMapping("/delete/{id}")
    public void blogDeleteById(@RequestParam String id) {
        log.info("blogDeleteById(String) -> | Id : {}",id);
        service.blogDeleteById(id);
        log.info("blogDeleteById(String) -> | Id : {} | Completed",id);
    }

    @DeleteMapping("/deleteAll")
    public void blogDeleteAll() {
        log.info("blogDeleteAll() -> | ");
        service.blogDeleteAll();
        log.info("blogDeleteAll() -> | Completed");
    }

}
