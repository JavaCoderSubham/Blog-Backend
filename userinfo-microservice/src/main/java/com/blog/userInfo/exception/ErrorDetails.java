package com.blog.userInfo.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErrorDetails {

	private Date timestamp;
	private String error;
	private String url;
	
	
	
}
