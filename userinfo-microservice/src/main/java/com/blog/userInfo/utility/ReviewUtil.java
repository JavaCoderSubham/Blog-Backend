package com.blog.userInfo.utility;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.blog.userInfo.entity.Review;

@FeignClient(name="USER-SERVICE" , url="http://localhost:8030/review/")
public interface ReviewUtil {

	@PostMapping("/create")
	public ResponseEntity<Review> createReview(@RequestBody Review review);

	@PostMapping("/update/{id}")
	public ResponseEntity<Review> updateReview(@PathVariable String id,@RequestBody Review review);
 
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Map<String,String>> deleteById(String id);
	 //Map<String,String> deleteById(String id);
} 
