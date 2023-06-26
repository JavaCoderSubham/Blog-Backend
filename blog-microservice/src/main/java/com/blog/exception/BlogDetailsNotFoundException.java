package com.blog.exception;

public class BlogDetailsNotFoundException extends RuntimeException{

    public BlogDetailsNotFoundException() {
        super("Blog Details Not Found Exception");
    }

}
