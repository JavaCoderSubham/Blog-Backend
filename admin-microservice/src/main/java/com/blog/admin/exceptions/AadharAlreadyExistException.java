package com.blog.admin.exceptions;

public class AadharAlreadyExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AadharAlreadyExistException() {
		super("Aadhar number already registered");
	}
}
