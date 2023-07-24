//package com.blog.userInfo.utility;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.blog.userInfo.entity.Review;
//
//@RestController
//@RequestMapping("/review")
//public class ReviewUtilityImpl {
//
//	@Autowired
//	ReviewUtil reviewUtil;
//	
//	@PostMapping("/createReview")
//	public ResponseEntity<Review> create(@RequestBody Review review){
//		return reviewUtil.createReview(review);
//	}
//}
