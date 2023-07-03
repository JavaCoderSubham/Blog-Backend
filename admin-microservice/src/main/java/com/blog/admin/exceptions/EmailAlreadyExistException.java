package com.blog.admin.exceptions;

public class EmailAlreadyExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailAlreadyExistException() {
		super("Email id already exist");
	}
}
