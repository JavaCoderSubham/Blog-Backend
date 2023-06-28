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

import com.blog.userInfo.entity.UserDetails;
import com.blog.userInfo.exception.NotFound;
import com.blog.userInfo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	ResponseEntity<UserDetails> createUser(@RequestBody UserDetails user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user));
	}
	
	@GetMapping("/getAll")
	ResponseEntity<List<UserDetails>> getall(){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
	}
	
	@GetMapping("/getById/{id}")
	ResponseEntity<UserDetails> getById(@PathVariable int id) throws NotFound{
		return ResponseEntity.status(HttpStatus.OK).body(userService.getById(id));
	}
	
	@DeleteMapping("/delById/{id}")
	ResponseEntity<String> delById(@PathVariable int id) throws NotFound{
		return ResponseEntity.status(HttpStatus.OK).body(userService.deleteById(id));
	}
	
	
	@PostMapping("/updateById/{id}")
	ResponseEntity<UserDetails> update(@RequestBody UserDetails userDetails ,@PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).body(userService.update(userDetails, id));
	}

	//*******************************************************//
	
	@GetMapping("/findByName/{name}")
	ResponseEntity<List<UserDetails>> findByName(@PathVariable String name) throws NotFound{
		return ResponseEntity.status(HttpStatus.OK).body(userService.findByName(name));
	}
	
	
	@GetMapping("findByCity/{city}")
	ResponseEntity<List<UserDetails>> findByCity(@PathVariable String city) throws NotFound{
		return ResponseEntity.status(HttpStatus.OK).body(userService.findByCity(city));
	}

	@GetMapping("findByState/{state}")
	ResponseEntity<List<UserDetails>> findByState(@PathVariable String state) throws NotFound{
		return ResponseEntity.status(HttpStatus.OK).body(userService.findByState(state));
	}
	
	@GetMapping("findByemail/{email}")
	ResponseEntity<UserDetails> findByEmail(@PathVariable String email) throws NotFound{
		return ResponseEntity.status(HttpStatus.OK).body(userService.findByEmail(email));
	}

	@GetMapping("findByphoneNo/{phoneNo}")
	ResponseEntity<UserDetails> findByphoneNo(@PathVariable long phoneNo) throws NotFound{
		return ResponseEntity.status(HttpStatus.OK).body(userService.findByPhoneNo(phoneNo));
	}
	
}


