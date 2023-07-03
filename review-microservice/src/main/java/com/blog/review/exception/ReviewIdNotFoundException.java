package com.blog.review.exception;

public class ReviewIdNotFoundException extends RuntimeException {

    public ReviewIdNotFoundException(String id) {
        super("Review Id Not Found Exception Id : " + id);
    }
}
