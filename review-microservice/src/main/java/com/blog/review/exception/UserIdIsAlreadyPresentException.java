package com.blog.review.exception;

public class UserIdIsAlreadyPresentException extends RuntimeException {
    public UserIdIsAlreadyPresentException(String userId) {
        super("UserId is Already Present Exception And id : " + userId);
    }
}
