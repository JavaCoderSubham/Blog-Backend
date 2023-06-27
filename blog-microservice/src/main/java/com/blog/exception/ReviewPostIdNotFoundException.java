package com.blog.exception;

public class ReviewPostIdNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReviewPostIdNotFoundException() {
        super("Review Post Id Not Found Exception");
    }

}
