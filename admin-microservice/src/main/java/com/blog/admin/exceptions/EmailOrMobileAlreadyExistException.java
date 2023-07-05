package com.blog.admin.exceptions;

public class EmailOrMobileAlreadyExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailOrMobileAlreadyExistException() {
		super("Email id or mobile number already exist");
	}
}