package com.blog.controller;

import java.util.HashMap;
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

import com.blog.dto.OwnerDto;
import com.blog.entity.Owner;
import com.blog.service.OwnerService;
 
@RestController
@RequestMapping("/superAdmin")
public class OwnerController {

	private final OwnerService ownerService;

	
	@Autowired
	public OwnerController(OwnerService ownerService) {
		this.ownerService=ownerService;
	}
	
	@PostMapping("/create")
	ResponseEntity<Owner> create (@RequestBody Owner owner){
		Owner create = ownerService.create(owner);
		return ResponseEntity.status(HttpStatus.CREATED).body(create);
	}
	
	@DeleteMapping("/delete")
	ResponseEntity<String> delete(@PathVariable String  id){
		String delete = ownerService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(delete);
	}
	
	@PostMapping("/update")
	ResponseEntity<OwnerDto> update(@PathVariable String id , @RequestBody Owner owner){
		OwnerDto update = ownerService.update(id, owner);
		return ResponseEntity.status(HttpStatus.CREATED).body(update);
	}
	
	@GetMapping("/getBy  Id/{id}")
	ResponseEntity<OwnerDto> getById(@PathVariable String id){
		OwnerDto byId = ownerService.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(byId);
	}
	
	@GetMapping("/findByEmail/{email}")
	ResponseEntity<OwnerDto> findbYEmail(@PathVariable String email){
		OwnerDto findByEmail = ownerService.findByEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body(findByEmail);
	}
	 
	@GetMapping("/findByMobileNo/{mobileNo}")
	ResponseEntity<OwnerDto> findByMobileNo(@PathVariable String mobileNo){
		OwnerDto findByMobileNo = ownerService.findByMobileNo(mobileNo);
		return ResponseEntity.status(HttpStatus.OK).body(findByMobileNo);
				}
	
	@PostMapping("/changePassword/{email}")
	public ResponseEntity<Map<String, String>> changePassword(@PathVariable String email, @RequestParam String newPassword){
		ownerService.changePassword(email, newPassword);
		Map<String,String> map = new HashMap<>();
		map.put("change password", "YOur password has been changed successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(map);
	}
	    
}
