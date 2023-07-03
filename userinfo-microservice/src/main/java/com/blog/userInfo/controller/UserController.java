package com.blog.userInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.userInfo.dao.UserDetailsDao;
import com.blog.userInfo.entity.Address;
import com.blog.userInfo.entity.UserInfo;
import com.blog.userInfo.exception.RecordNotFound;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDetailsDao userService;
	
	@PostMapping("/create")
	public ResponseEntity<UserInfo> createUser(@RequestBody UserInfo user){
		log.info("=======CreateUser Started=======");
		log.info("create(User)-> | User : {}",user);
		log.info("=======CreateUser Ended=======");
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user));
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<UserInfo>> getall(){
		log.info("=======GetAllUser Started=======");
		List<UserInfo> all = userService.getAll();
		log.info("getAll()-> | List User : {}",all);
		log.info("=======GetAllUser Ended=======");
		return ResponseEntity.status(HttpStatus.OK).body(all);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<UserInfo> getById(@PathVariable String id) throws RecordNotFound{
		log.info("=======GetById User Started=======");
		UserInfo user =userService.getById(id);
		log.info("GetBYId(id)-> | id : {}",user);
		log.info("=======GetById User Ended=======");
		//return ResponseEntity.ok(user);
		return new ResponseEntity<UserInfo>(user, HttpStatus.OK); 
	}
	
	@DeleteMapping("/delById/{id}")
	public ResponseEntity<String> delById(@PathVariable String id) throws RecordNotFound{
		log.info("========deleteBYId started=======");
		String details = userService.deleteById(id);
		log.info("delById(id)-> | id : {}", details);
		ResponseEntity<String> body = ResponseEntity.status(HttpStatus.OK).body(details);
		log.info("========deleteById Ended");
		return body;
	}
	
	
	@PostMapping("/updateById/{id}")
	ResponseEntity<UserInfo> update(@RequestBody UserInfo userDetails ,@PathVariable String id){
		log.info("=========UpdateById Started========");
		UserInfo details = userService.update(userDetails, id);
		log.info("updateById(id)-> | id : {}",details);
		ResponseEntity<UserInfo> body = ResponseEntity.status(HttpStatus.OK).body(details);
		log.info("========updateById Ended========");
		return body;
	}

	//*******************************************************//
	
	@GetMapping("/findByName/{name}")
	ResponseEntity<List<UserInfo>> findByName(@PathVariable String name) throws RecordNotFound{
		log.info("========findByName Started========");
		List<UserInfo> details = userService.findByName(name);
		log.info("findByName(name)-> | name : {}", details);
		log.info("========findByName Ended========");
		return ResponseEntity.status(HttpStatus.OK).body(details);
	}
	
	
//	@GetMapping("findByCity/{city}")
//	ResponseEntity<List<UserInfo>> findByCity(@PathVariable String city) throws NotFound{
//		log.info("=======findByCity Started=======");
//		List<UserInfo> details = userService.findByCity(city);
//		log.info("findByCity(city)-> | city : {}", details);
//		log.info("========findByCity Ended========");
//		return ResponseEntity.status(HttpStatus.OK).body(details);
//	}
//
//	@GetMapping("findByState/{state}")
//	ResponseEntity<List<UserInfo>> findByState(@PathVariable String state) throws NotFound{
//		log.info("=======findByState Started=======");
//		List<UserInfo> details = userService.findByState(state);
//		log.info("findByState(state)-> | state : {}", details);
//		log.info("========findByState Ended========");
//		return ResponseEntity.status(HttpStatus.OK).body(details);
//	}
	
	@GetMapping("findByemail/{email}")
	ResponseEntity<UserInfo> findByEmail(@PathVariable String email) throws RecordNotFound{
		log.info("=======findByEmail Started=======");
		UserInfo details = userService.findByEmail(email);
		log.info("findByEmail(email)-> | email : {}", details);
		log.info("========findByEmail Ended========");
		return ResponseEntity.status(HttpStatus.OK).body(details);
	}

	@GetMapping("findByphoneNo/{phoneNo}")
	ResponseEntity<UserInfo> findByphoneNo(@PathVariable String phoneNo) throws RecordNotFound{
		log.info("=======findByPhoneNo Started=======");
		UserInfo details = userService.findByPhoneNo(phoneNo);
		log.info("findByState(phoneNo)-> | phoneNo : {}", details);
		log.info("========findByPhoneNo Ended========");
		return ResponseEntity.status(HttpStatus.OK).body(details);
	}
	
}


