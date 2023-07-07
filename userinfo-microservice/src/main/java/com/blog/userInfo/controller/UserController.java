package com.blog.userInfo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.userInfo.dao.UserDetailsDao;
import com.blog.userInfo.dto.UserInfoDto;
import com.blog.userInfo.entity.UserInfo;
import com.blog.userInfo.entity.UserProjectionEmail;
import com.blog.userInfo.entity.UserProjectionPhoneNo;
import com.blog.userInfo.exception.RecordNotFound;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {


	private final UserDetailsDao userService;
	
	@Autowired
	public UserController (UserDetailsDao userService) {
		this.userService = userService;
	}

	//UserCreate Endpoint
	@PostMapping("/create")
	public ResponseEntity<UserInfo> createUser(@RequestBody UserInfo user) {
		log.info("======= UserController CreateUser  Started=======");
		log.info("create(User)-> | User : {}", user);
		log.info("=======UserController CreateUser Ended=======");
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user));

	}
	//Usergetall details endPoint
	@GetMapping("/getAll")
	public ResponseEntity<List<UserInfoDto>> getall() {
		log.info("=======UserController GetAllUser Started=======");
		List<UserInfoDto> all = userService.getAll();
		log.info("UserController getAll()-> | List User : {}", all);
		log.info("=======UserController GetAllUser Ended=======");
		return ResponseEntity.status(HttpStatus.OK).body(all);
	}

	//user getById endPoint
	@GetMapping("/getById/{id}")
	public ResponseEntity<UserInfoDto> getById(@PathVariable String id) throws RecordNotFound {
		log.info("=======UserController GetById User Started=======");
		UserInfoDto user = userService.getById(id);
		log.info("UserController GetBYId(id)-> | id : {}", user);
		log.info("=======UserController GetById User Ended=======");
		return new ResponseEntity<UserInfoDto>(user, HttpStatus.OK);
	}

	//user deleteById endPoint
	@DeleteMapping("/delById/{id}")
	public ResponseEntity<String> delById(@PathVariable String id) throws RecordNotFound {
		log.info("========UserController deleteBYId started=======");
		String details = userService.deleteById(id);
		log.info("UserController delById(id)-> | id : {}", details);
		ResponseEntity<String> body = ResponseEntity.status(HttpStatus.OK).body(details);
		log.info("========UserController deleteById Ended");
		return body;
	}

	//user UpdateByid endpoint
	@PostMapping("/updateById/{id}")
	public ResponseEntity<UserInfo> update(@RequestBody UserInfo userDetails, @PathVariable String id) {
		log.info("=========UserController UpdateById Started========");
		UserInfo details = userService.update(userDetails, id);
		log.info("UserController updateById(id)-> | id : {}", details);
		ResponseEntity<UserInfo> body = ResponseEntity.status(HttpStatus.OK).body(details);
		log.info("========UserController updateById Ended========");
		return body;
	}

	// *******************************************************//
	//user findByName endpoint
	@GetMapping("/findByName/{name}")
	public ResponseEntity<List<UserInfoDto>> findByName(@PathVariable String name) throws RecordNotFound {
		log.info("========UserController findByName Started========");
		List<UserInfoDto> details = userService.findByName(name);
		log.info("UserController findByName(name)-> | name : {}", details);
		log.info("========UserController findByName Ended========");
		return ResponseEntity.status(HttpStatus.OK).body(details);
	}

	//user findByCity endpoint
	@GetMapping("findByCity/{city}")
	public ResponseEntity<List<UserInfoDto>> findByCity(@PathVariable String city) throws RecordNotFound {
		log.info("=======UserController findByCity Started=======");
		List<UserInfoDto> details = userService.findByAddressCity(city);
		log.info("findByCity(city)-> | city : {}", details);
		log.info("========UserController findByCity Ended========");
		return ResponseEntity.status(HttpStatus.OK).body(details);
	}

	//user findBystate endPoint
	@GetMapping("findByState/{state}")
	public ResponseEntity<List<UserInfoDto>> findByAddressState(@PathVariable String state) throws RecordNotFound {
		log.info("=======UserController findByState Started=======");
		List<UserInfoDto> details = userService.findByAddressState(state);
		log.info("UserController findByState(state)-> | state : {}", details);
		log.info("========UserController findByState Ended========");
		return ResponseEntity.status(HttpStatus.OK).body(details);
	}

	//user findByEmail endPoint
	@GetMapping("findByemail/{email}")
	public ResponseEntity<UserProjectionEmail> findByEmail(@PathVariable String email) throws RecordNotFound {
		log.info("=======UserController findByEmail Started=======");
		UserProjectionEmail details = userService.findByEmail(email);
		log.info("UserController findByEmail(email)-> | email : {}", details);
		log.info("========UserController findByEmail Ended========");
		return ResponseEntity.status(HttpStatus.OK).body(details);
	}

	//user findByphoneNumber endpoint
	@GetMapping("findByphoneNo/{phoneNo}")
	public ResponseEntity<UserProjectionPhoneNo> findByphoneNo(@PathVariable String phoneNo) throws RecordNotFound {
		log.info("=======UserController findByPhoneNo Started=======");
		UserProjectionPhoneNo details = userService.findByPhoneNo(phoneNo);
		log.info("UserController findByState(phoneNo)-> | phoneNo : {}", details);
		log.info("========UserController findByPhoneNo Ended========");
		return ResponseEntity.status(HttpStatus.OK).body(details);
	}

	//user change password endpoint
	@PostMapping("changePassword/{email}")
	public ResponseEntity<Map<String,String>> changePassword(@PathVariable String email, @RequestParam String newPassword) throws RecordNotFound{
		log.info("=======UserController changePassword Started=======");
		userService.changePassword(email, newPassword);
		Map<String, String> map =new HashMap<>();
		map.put("change password","You have successfully changed your password");
		log.info("=======UserController chnagePassword Ended	11q`=======");
		return ResponseEntity.status(HttpStatus.CREATED).body(map);
	}
}
