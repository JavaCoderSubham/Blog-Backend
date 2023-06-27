package com.blog.exception;

public class BlogDetailsImageNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlogDetailsImageNotFoundException() {
        super("Blog Details Image Not Found Exception");
    }
}
