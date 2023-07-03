package com.blog.admin.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ErrorDetails {
	private Date timestamp;
	private String error;
	private String details;
}
