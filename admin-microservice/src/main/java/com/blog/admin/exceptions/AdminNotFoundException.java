package com.blog.admin.exceptions;

public class AdminNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AdminNotFoundException() {
		super("Admin not found");
	}
}
