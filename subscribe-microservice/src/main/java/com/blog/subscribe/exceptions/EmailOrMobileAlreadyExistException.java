package com.blog.subscribe.exceptions;

public class EmailOrMobileAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmailOrMobileAlreadyExistException() {
		super("Email or Mobile already exists, please try with other email or mobile number");
	}
}
