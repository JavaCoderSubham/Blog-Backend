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
import com.blog.admin.entity.AdminDto;
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
	public ResponseEntity<List<AdminDto>> findAllAdmins() {
		List<AdminDto> admins = adminService.findAllAdmins();
		return new ResponseEntity<List<AdminDto>>(admins, HttpStatus.OK);
	}
	
	@GetMapping("/findbyemail/{email}")
	public ResponseEntity<AdminDto> findAdminByEmail(@PathVariable String email) {
		AdminDto admin = adminService.findAdminByEmail(email);
		return new ResponseEntity<AdminDto>(admin, HttpStatus.OK);
	}
	
	@GetMapping("/findbymobile/{mobile}")
	public ResponseEntity<AdminDto> findAdminByMobile(@PathVariable String mobile) {
		AdminDto admin = adminService.findAdminByMobileNumber(mobile);
		return new ResponseEntity<AdminDto>(admin, HttpStatus.OK);
	}
	
	@GetMapping("/findbyaadhar/{aadhar}")
	public ResponseEntity<AdminDto> findAdminByAadhar(@PathVariable String aadhar) {
		AdminDto admin = adminService.findAdminByAadhar(aadhar);
		return new ResponseEntity<AdminDto>(admin, HttpStatus.OK);
	}
	
	@GetMapping("/findbycity/{city}")
	public ResponseEntity<List<AdminDto>> findAdminByCity(@PathVariable String city) {
		List<AdminDto> admins = adminService.findAdminByAddressCity(city);
		return new ResponseEntity<List<AdminDto>>(admins, HttpStatus.OK);
	}
	
	@GetMapping("/findbypincode/{pincode}")
	public ResponseEntity<List<AdminDto>> findAdminByPincode(@PathVariable Integer pincode) {
		List<AdminDto> admins = adminService.findAdminByAddressPincode(pincode);
		return new ResponseEntity<List<AdminDto>>(admins, HttpStatus.OK);
	}
	
	@GetMapping("/findbystate/{state}")
	public ResponseEntity<List<AdminDto>> findAdminByState(@PathVariable String state) {
		List<AdminDto> admins = adminService.findAdminByAddressCity(state);
		return new ResponseEntity<List<AdminDto>>(admins, HttpStatus.OK);
	}
	
	@PutMapping("/changepassword/{id}")
	public ResponseEntity<	Map<String, String>> changePassword(@PathVariable String email, @RequestParam String newPassword) {
		adminService.changePassword(email, newPassword);
		Map<String, String> map = new HashMap<>();
		map.put("changePassword", "You have changed your password successfully");
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
	}
	
	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<AdminDto> updateAdminById(@PathVariable String id, @RequestBody AdminDto admin) {
		AdminDto updatedAdmin = adminService.updateAdminById(id, admin);
		return new ResponseEntity<AdminDto>(updatedAdmin, HttpStatus.CREATED);
	}
	
	@PutMapping("/updatebyemail/{email}")
	public ResponseEntity<AdminDto> updateAdminByEmail(@PathVariable String email, @RequestBody AdminDto admin) {
		AdminDto updatedAdmin = adminService.updateAdminByEmail(email, admin);
		return new ResponseEntity<AdminDto>(updatedAdmin, HttpStatus.CREATED);
	}
	
	@PutMapping("/updatebymobile/{mobileNumber}")
	public ResponseEntity<AdminDto> updateAdminByMobileNumber(@PathVariable String mobileNumber, @RequestBody AdminDto admin) {
		AdminDto updatedAdmin = adminService.updateAdminByMobileNumber(mobileNumber, admin);
		return new ResponseEntity<AdminDto>(updatedAdmin, HttpStatus.CREATED);
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
