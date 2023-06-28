package com.blog.exception;

public class BlogDetailsNotFoundException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlogDetailsNotFoundException() {
        super("Blog Details Not Found Exception");
    }

}
