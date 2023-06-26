package com.blog.exception;

public class ReviewPostIdNotFoundException extends RuntimeException {

    public ReviewPostIdNotFoundException() {
        super("Review Post Id Not Found Exception");
    }

}
