package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.OwnerDto;
import com.blog.service.OwnerServiceImplementation;

@RestController
@RequestMapping("/superAdmin")
public class OwnerController {

	@Autowired
	public OwnerServiceImplementation serviceImplementation;
	
	@PostMapping("/post")
	public ResponseEntity<OwnerDto> saveSuperAdmin(@RequestBody OwnerDto dto){
		OwnerDto owner = serviceImplementation.create(dto);
		return new ResponseEntity<>(owner, HttpStatus.ACCEPTED);
	}
}
