package com.blog.subscribe.exceptions;

public class SubscriberNotFoundException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SubscriberNotFoundException() {
        super("Subscriber Not Found");
    }
}
