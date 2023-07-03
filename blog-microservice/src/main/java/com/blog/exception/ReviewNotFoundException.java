package com.blog.exception;

public class ReviewNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReviewNotFoundException() {
        super("Review Not Found Exception");
    }
}
