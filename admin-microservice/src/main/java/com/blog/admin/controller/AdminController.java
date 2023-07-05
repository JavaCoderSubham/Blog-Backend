package com.blog.admin.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.admin.entity.Admin;
import com.blog.admin.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/create")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
		Admin save = adminService.createAdmin(admin);
		return new ResponseEntity<Admin>(save, HttpStatus.CREATED);
	}
	
	@GetMapping("/findall")
	public ResponseEntity<List<Admin>> findAllAdmins() {
		List<Admin> admins = adminService.findAllAdmins();
		return new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
	}
	
	@GetMapping("/findbyemail/{email}")
	public ResponseEntity<Admin> findAdminByEmail(@PathVariable String email) {
		Admin admin = adminService.findAdminByEmail(email);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
	
	@GetMapping("/findbymobile/{mobile}")
	public ResponseEntity<Admin> findAdminByMobile(@PathVariable String mobile) {
		Admin admin = adminService.findAdminByMobileNumber(mobile);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
	
	@GetMapping("/findbyaadhar/{aadhar}")
	public ResponseEntity<Admin> findAdminByAadhar(@PathVariable String aadhar) {
		Admin admin = adminService.findAdminByAadhar(aadhar);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
	
	@GetMapping("/findbycity/{city}")
	public ResponseEntity<List<Admin>> findAdminByCity(@PathVariable String city) {
		List<Admin> admins = adminService.findAdminByAddressCity(city);
		return new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
	}
	
	@GetMapping("/findbypincode/{pincode}")
	public ResponseEntity<List<Admin>> findAdminByPincode(@PathVariable Integer pincode) {
		List<Admin> admins = adminService.findAdminByAddressPincode(pincode);
		return new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
	}
	
	@GetMapping("/findbystate/{state}")
	public ResponseEntity<List<Admin>> findAdminByState(@PathVariable String state) {
		List<Admin> admins = adminService.findAdminByAddressCity(state);
		return new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
	}
	
	@PutMapping("/changepassword/{id}")
	public ResponseEntity<	Map<String, String>> changePassword(@PathVariable String email, @RequestParam String newPassword) {
		adminService.changePassword(email, newPassword);
		Map<String, String> map = new HashMap<>();
		map.put("changePassword", "You have changed your password successfully");
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
	}
	
	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Admin> updateAdminById(@PathVariable String id, @RequestBody Admin admin) {
		Admin updatedAdmin = adminService.updateAdminById(id, admin);
		return new ResponseEntity<Admin>(updatedAdmin, HttpStatus.CREATED);
	}
	
	@PutMapping("/updatebyemail/{email}")
	public ResponseEntity<Admin> updateAdminByEmail(@PathVariable String email, @RequestBody Admin admin) {
		Admin updatedAdmin = adminService.updateAdminByEmail(email, admin);
		return new ResponseEntity<Admin>(updatedAdmin, HttpStatus.CREATED);
	}
	
	@PutMapping("/updatebymobile/{mobileNumber}")
	public ResponseEntity<Admin> updateAdminByMobileNumber(@PathVariable String mobileNumber, @RequestBody Admin admin) {
		Admin updatedAdmin = adminService.updateAdminByMobileNumber(mobileNumber, admin);
		return new ResponseEntity<Admin>(updatedAdmin, HttpStatus.CREATED);
	}
	
	@DeleteMapping("deletebyid/{id}")
	public ResponseEntity<Map<String, String>> deleteAdminById(@PathVariable String id) {
		adminService.deleteAdminById(id);
		Map<String, String> map = new HashMap<>();
		map.put("deleteAdmin", "You have deleted successfully with id " + id);
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
	}
	
	@DeleteMapping("deletebyemail/{email}")
	public ResponseEntity<Map<String, String>> deleteAdminByEmail(@PathVariable String email) {
		adminService.deleteAdminByEmail(email);
		Map<String, String> map = new HashMap<>();
		map.put("deleteAdmin", "You have deleted successfully with email " + email);
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
	}
	
	@DeleteMapping("deletebymobile/{mobile}")
	public ResponseEntity<Map<String, String>> deleteAdminByMobileNumber(@PathVariable String mobileNumber) {
		adminService.deleteAdminByMobileNumber(mobileNumber);
		Map<String, String> map = new HashMap<>();
		map.put("deleteAdmin", "You have deleted successfully with mobile number " + mobileNumber);
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
	}
}
