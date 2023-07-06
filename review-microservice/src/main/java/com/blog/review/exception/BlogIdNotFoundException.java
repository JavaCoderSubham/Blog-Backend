package com.blog.review.exception;

public class BlogIdNotFoundException extends RuntimeException {
    public BlogIdNotFoundException(String id) {
        super("Blog ID : "+id+" Not Found Exception");
    }
}
