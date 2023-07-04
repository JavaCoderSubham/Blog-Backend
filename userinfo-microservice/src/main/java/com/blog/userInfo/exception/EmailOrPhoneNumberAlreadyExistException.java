package com.blog.userInfo.exception;

public class EmailOrPhoneNumberAlreadyExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailOrPhoneNumberAlreadyExistException() {
		super("Email or phone number already exist");
	}
}
