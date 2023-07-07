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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	//==================Create Admin Method====================
	@PostMapping("/create")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
		log.info("==============Create Admin Started===============");
		log.info("create(Admin) -> | Admin : {}", admin);
		Admin save = adminService.createAdmin(admin);
		log.info("create(Admin) -> | Admin after service : {}", admin);
		log.info("==============Create Admin Ended===============");
		return new ResponseEntity<Admin>(save, HttpStatus.CREATED);
	}

	//========================Find Admin Methods===========================
	
	@GetMapping("/findall")
	public ResponseEntity<List<AdminDto>> findAllAdmins() {
		log.info("=============Find All Admins Method Strated==============");
		log.info("findAllAdmins() -> | Admin : ");
		List<AdminDto> admins = adminService.findAllAdmins();
		log.info("findAllAdmins() -> | Admin After Service : {}", admins);
		log.info("=============Find All Admins Method Ended==============");
		return new ResponseEntity<List<AdminDto>>(admins, HttpStatus.OK);
	}

	@GetMapping("/findbyemail/{email}")
	public ResponseEntity<AdminDto> findAdminByEmail(@PathVariable String email) {
		log.info("============Find Admin By Email Started============");
		log.info("findAdminByEmail() -> | Email : {}", email);
		AdminDto admin = adminService.findAdminByEmail(email);
		log.info("findAdminByEmail() -> | Admin By Email After Service : {}", email);
		log.info("============Find Admin By Email Ended==============");
		return new ResponseEntity<AdminDto>(admin, HttpStatus.OK);
	}

	@GetMapping("/findbymobile/{mobile}")
	public ResponseEntity<AdminDto> findAdminByMobile(@PathVariable String mobile) {
		log.info("============Find Admin By Mobile Number Started============");
		log.info("findAdminByMobile() -> | Mobile Number : {}", mobile);
		AdminDto admin = adminService.findAdminByMobileNumber(mobile);
		log.info("findAdminByMobile() -> | Admin By Mobile Number After Service : {}", admin);
		log.info("============Find Admin By Mobile Number Ended==============");
		return new ResponseEntity<AdminDto>(admin, HttpStatus.OK);
	}

	@GetMapping("/findbyaadhar/{aadhar}")
	public ResponseEntity<AdminDto> findAdminByAadhar(@PathVariable String aadhar) {
		log.info("============Find Admin By Aadhar Started============");
		log.info("findAdminByAadhar() -> | Aadhar : {}", aadhar);
		AdminDto admin = adminService.findAdminByAadhar(aadhar);
		log.info("findAdminByAadhar() -> | Admin By Aadhar After Service : {}", admin);
		log.info("============Find Admin By Aadhar Ended============");
		return new ResponseEntity<AdminDto>(admin, HttpStatus.OK);
	}

	@GetMapping("/findbycity/{city}")
	public ResponseEntity<List<AdminDto>> findAdminByCity(@PathVariable String city) {
		log.info("============Find Admins By City Started============");
		log.info("findAdminByCity() -> | City : {}", city);
		List<AdminDto> admins = adminService.findAdminByAddressCity(city);
		log.info("findAdminByCity() -> |Admins By City After Service : {}", admins);
		log.info("============Find Admins By City Ended============");
		return new ResponseEntity<List<AdminDto>>(admins, HttpStatus.OK);
	}

	@GetMapping("/findbypincode/{pincode}")
	public ResponseEntity<List<AdminDto>> findAdminByPincode(@PathVariable Integer pincode) {
		log.info("============Find Admins By Pincode Started============");
		log.info("findAdminByPincode() -> | Pincode : {}", pincode);
		List<AdminDto> admins = adminService.findAdminByAddressPincode(pincode);
		log.info("findAdminByPincode() -> |Admins By Pincode After Service : {}", admins);
		log.info("============Find Admins By Pincode Ended============");
		return new ResponseEntity<List<AdminDto>>(admins, HttpStatus.OK);
	}

	@GetMapping("/findbystate/{state}")
	public ResponseEntity<List<AdminDto>> findAdminByState(@PathVariable String state) {
		log.info("============Find Admins By State Started============");
		log.info("findAdminByState() -> | State : {}", state);
		List<AdminDto> admins = adminService.findAdminByAddressState(state);
		log.info("findAdminByState() -> |Admins By State After Service : {}", admins);
		log.info("============Find Admins By State Ended============");
		return new ResponseEntity<List<AdminDto>>(admins, HttpStatus.OK);
	}

	//========================Change Admin Password Method================================
	
	@PutMapping("/changepassword/{id}")
	public ResponseEntity<Map<String, String>> changePassword(@PathVariable String email,
			@RequestParam String newPassword) {
		log.info("=============Change Password Started==============");
		log.info("changePassword() -> | Email : {}", email);
		log.info("vhangePassword() -> | New Password : {}", newPassword);
		adminService.changePassword(email, newPassword);
		log.info("vhangePassword() -> | New Password After Service : {}", newPassword);
		Map<String, String> map = new HashMap<>();
		map.put("changePassword", "You have changed your password successfully");
		log.info("============Change Password Ended  ==========");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}

	//===========================Update Admin methods===============================
	
	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<AdminDto> updateAdminById(@PathVariable String id, @RequestBody AdminDto admin) {
		log.info("==============Update Admin By Id Started================");
		log.info("updateAdminById() -> | Admin Id : {}", id);
		log.info("updateAdminById() -> | Admin Before Service {}: ", admin);
		AdminDto updatedAdmin = adminService.updateAdminById(id, admin);
		log.info("updateAdminById() -> | Admin After Update : {}", admin);
		log.info("==============Update Admin By Id Ended==================");
		return new ResponseEntity<AdminDto>(updatedAdmin, HttpStatus.CREATED);
	}

	@PutMapping("/updatebyemail/{email}")
	public ResponseEntity<AdminDto> updateAdminByEmail(@PathVariable String email, @RequestBody AdminDto admin) {
		log.info("==============Update Admin By Email Started================");
		log.info("updateAdminByEmail() -> | Admin Email : {}", email);
		log.info("updateAdminByEmail() -> | Admin Before Service {}: ", admin);
		AdminDto updatedAdmin = adminService.updateAdminByEmail(email, admin);
		log.info("updateAdminByEmail() -> | Admin After Update : {}", admin);
		log.info("==============Update Admin By Email Ended==================");
		return new ResponseEntity<AdminDto>(updatedAdmin, HttpStatus.CREATED);
	}

	@PutMapping("/updatebymobile/{mobileNumber}")
	public ResponseEntity<AdminDto> updateAdminByMobileNumber(@PathVariable String mobileNumber,
			@RequestBody AdminDto admin) {
		log.info("==============Update Admin By Mobile Number Started================");
		log.info("updateAdminByMobile() -> | Admin Mobile : {}", mobileNumber);
		log.info("updateAdminByMobile() -> | Admin Before Service {}: ", admin);
		AdminDto updatedAdmin = adminService.updateAdminByMobileNumber(mobileNumber, admin);
		log.info("updateAdminByMobile() -> | Admin After Update : {}", admin);
		log.info("==============Update Admin By Mobile Number Ended==================");
		return new ResponseEntity<AdminDto>(updatedAdmin, HttpStatus.CREATED);
	}

	//===========================Detele Admin Methods=========================
	
	@DeleteMapping("deletebyid/{id}")
	public ResponseEntity<Map<String, String>> deleteAdminById(@PathVariable String id) {
		log.info("===============Delete Admin By Id Started=================");
		log.info("deleteAdminById() -> | Delete Admin Id : {}", id);
		adminService.deleteAdminById(id);
		log.info("deleteAdminById() -> | Deleted Admin Id : {}", id);
		Map<String, String> map = new HashMap<>();
		map.put("deleteAdmin", "You have deleted successfully with id " + id);
		log.info("===============Delete Admin By Id Ended====================");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}

	@DeleteMapping("deletebyemail/{email}")
	public ResponseEntity<Map<String, String>> deleteAdminByEmail(@PathVariable String email) {
		log.info("===============Delete Admin By Email Started=================");
		log.info("deleteAdminByEmail() -> | Delete Admin Email : {}", email);
		adminService.deleteAdminByEmail(email);
		log.info("deleteAdminByEmail() -> | Deleted Admin Email : {}", email);
		Map<String, String> map = new HashMap<>();
		map.put("deleteAdmin", "You have deleted successfully with email " + email);
		log.info("===============Delete Admin By Email Ended====================");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}

	@DeleteMapping("deletebymobile/{mobile}")
	public ResponseEntity<Map<String, String>> deleteAdminByMobileNumber(@PathVariable String mobileNumber) {
		log.info("===============Delete Admin By Mobile Number Started=================");
		log.info("deleteAdminByMobile() -> | Delete Admin Mobile : {}", mobileNumber);
		adminService.deleteAdminByMobileNumber(mobileNumber);
		log.info("deleteAdminByMobile() -> | Deleted Admin Mobile : {}", mobileNumber);
		Map<String, String> map = new HashMap<>();
		map.put("deleteAdmin", "You have deleted successfully with mobile number " + mobileNumber);
		log.info("===============Delete Admin By Mobile Number Ended====================");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
}
