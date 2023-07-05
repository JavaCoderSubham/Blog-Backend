package com.blog.admin.exceptions;

public class NoAdminsFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NoAdminsFoundException() {
		super("No admin found");
	}
}
