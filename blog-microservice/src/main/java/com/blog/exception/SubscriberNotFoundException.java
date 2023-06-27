package com.blog.exception;

public class SubscriberNotFoundException extends RuntimeException{
    public SubscriberNotFoundException() {
        super("Subscriber Not Found");
    }
}
