package com.blog.dao.blogDetails;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.blog.entity.Review;
import org.springframework.stereotype.Component;

import com.blog.entity.BlogDetails;
import com.blog.exception.BlogDetailsNotFoundException;
import com.blog.repository.BlogDetailsRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;


@Slf4j
@Component
public class BlogDetailsDaoImpl implements BlogDetailsDao {

    private final BlogDetailsRepository repository;
    private final String baseUrlReview = "http://localhost:8030/review";

    private final WebClient webClient;

    public BlogDetailsDaoImpl(BlogDetailsRepository repository, WebClient webClient) {
        this.repository = repository;
        this.webClient = webClient;
    }

//    GET Methods

    @Override
    public List<BlogDetails> getAllBlog() {
        log.info("getAllBlog() -> | ");
        List<BlogDetails> all = repository.findAll();
        log.info("getAllBlog() -> | List BlogDetails : {}",all);
        return all;
    }

    @Override
    public BlogDetails getBlog(String id) {
        log.info("getBlog(String) -> | Id : {}",id);
        BlogDetails blogDetails = repository.findById(id).orElseThrow(() -> new BlogDetailsNotFoundException());
        log.info("getBlog(String) -> | BlogDetails : {}",blogDetails);
        return blogDetails;
    }

//    POST Create

    @Override
    public BlogDetails create(BlogDetails blogDetails) {

        log.info("create(BlogDetails) -> | Request BlogDetails : {}",blogDetails);
        blogDetails.setId(UUID.randomUUID().toString());
        log.info("create(BlogDetails) -> | After Set Id BlogDetails : {}",blogDetails);
        BlogDetails save = repository.save(blogDetails);
        log.info("create(BlogDetails) -> | After Save BlogDetails : {}",blogDetails);
        return save;
    }

//    PUT Create

    @Override
    public BlogDetails update(String id, BlogDetails blogDetails) {
        log.info("update(String,BlogDetails) -> | Id : {} | BlogDetails : {}",id,blogDetails);
        BlogDetails blog = getBlog(id);
        log.info("update(String,BlogDetails) -> | Present BlogDetails : {}",blog);
        blog.setBlogText(blogDetails.getBlogText());
        blog.setAuthor(blogDetails.getAuthor());
        blog.setTitle(blogDetails.getTitle());
        blog.setTopic(blogDetails.getTopic());
        blog.setHashTags(blogDetails.getHashTags());
        log.info("update(String,BlogDetails) -> | After Set BlogDetails : {}",blog);
        BlogDetails save = repository.save(blog);
        log.info("update(String,BlogDetails) -> | After Save BlogDetails : {}",save);
        return save;
    }

//    DELETE Methods

    @Override
    public void delete(String id) {
        log.info("delete(String) -> | Id : {}",id);
        getBlog(id);
        log.info("delete(String) -> | Present Id : {}",id);
        Map<String,String> block = webClient.delete()
                .uri(baseUrlReview + "/deleteByBlogId" + id)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
        log.info("delete(String) -> | Delete Message : {}",block);
        repository.deleteById(id);
        log.info("delete(String) -> | Deleted... ID : {}",id);
    }

    @Override
    public void deleteAll() {
        List<BlogDetails> allBlog = getAllBlog();
        for(BlogDetails blog : allBlog) {
            webClient.delete()
                    .uri(baseUrlReview + "/deleteByBlogId" + blog.getId())
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();
            log.info("deleteAll() -> | Delete BlogID : {}",blog.getId());
        }
        log.info("deleteAll() -> | Delete All Reviews to Related Blogs");
        log.info("deleteAll() -> | Delete Blogs");
        repository.deleteAll();
        log.info("deleteAll() -> | All Deleted");
    }

//    Find Methods

    @Override
    public List<BlogDetails> findByAuthor(String author) {
        log.info("findByAuthor(String) -> | Author : {}",author);
        List<BlogDetails> getAuthor = repository.findByAuthor(author);
        log.info("findByAuthor(String) -> | List BlogDetails : {}",getAuthor);
        return getAuthor;
    }

    @Override
    public List<BlogDetails> findByTitleStartingWith(String title) {
        log.info("findByTitleStartingWith(String) -> | Title : {}",title);
        List<BlogDetails> getTitle = repository.findByTitleStartingWith(title);
        log.info("findByTitleStartingWith(String) -> | List BlogDetails : {}",getTitle);
        return getTitle;
    }

    @Override
    public List<BlogDetails> findByTopicStartingWith(String topic) {
        log.info("findByTopicStartingWith(String) -> | Topic : {}",topic);
        List<BlogDetails> getTopic = repository.findByTopicStartingWith(topic);
        log.info("findByTopicStartingWith(String) -> | List BlogDetails : {}",getTopic);
        return getTopic;
    }

    @Override
    public List<BlogDetails> findByEmail(String email) {
        log.info("findByEmail(String) -> | Email : {}",email);
        List<BlogDetails> getEmail = repository.findByEmail(email);
        log.info("findByEmail(String) -> | List BlogDetails : {}",getEmail);
        return getEmail;
    }

    @Override
    public List<BlogDetails> findByBlogTextContaining(String blogText) {
        log.info("findByBlogTextStartingWith(String) -> | BlogText : {}",blogText);
        List<BlogDetails> getBlogText = repository.findByBlogTextContaining(blogText);
        log.info("findByBlogTextStartingWith(String) -> | List BlogDetails : {}",getBlogText);
        return getBlogText;
    }

}



