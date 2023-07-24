package com.blog.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.blog.admin.entity.Admin;
import com.blog.admin.entity.AdminDto;
import com.blog.admin.entity.BlogDetails;
import com.blog.admin.entity.dao.AdminDao;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private WebClient webClient;
	
	private final String baseUrl = "http://localhost:9000/blog";
	
	//========================Create Admin Method===========================
	
	@Override
	public Admin createAdmin(Admin admin) {
		log.info("create(Admin) -> | Subscribe : {}",admin);
		Admin save = adminDao.createAdmin(admin);
		log.info("create(Admin) -> | After execute Dao Create : {}",save);
		return save;
	}
	
	
	
	//========================Find Admin Methods==============================
	
	@Override
	public List<AdminDto> findAllAdmins() {
		log.info("getAll() -> | ");
		List<AdminDto> admins = adminDao.findAllAdmins();
		log.info("getAll() -> | List Admins : {}",admins);
		return admins;
	}
	
	@Override
	public AdminDto findAdminByEmail(String email) {
		log.info("findAdminByEmail() -> | Email : {}", email);
		AdminDto admin = adminDao.findAdminByEmail(email);
		log.info("findAdminByEmail() -> | Admin By Email : {}", admin);
		return admin;
	}
  
	@Override
	public AdminDto findAdminByAadhar(String aadharNumber) {
		log.info("findAdminByAadhar() -> | Aadhar Number : {}", aadharNumber);
		AdminDto admin = adminDao.findAdminByAadhar(aadharNumber);
		log.info("findAdminByAadhar() -> | Admin By Aadhar Number : {}", admin);
		return admin;
	}

	@Override
	public List<AdminDto> findAdminByAddressCity(String city) {
		log.info("findAdminByAddressCity() -> | City : {}", city);
		List<AdminDto> admins = adminDao.findAdminByAddressCity(city);
		log.info("findAdminByAddressCity() -> | Admins By city : {}", admins);
		return admins;
	}

	@Override
	public List<AdminDto> findAdminByAddressState(String state) {
		log.info("findAdminByAddressState() -> | State : {}", state);
		List<AdminDto> admins = adminDao.findAdminByAddressState(state);
		log.info("findAdminByAddressState() -> | Admins By State : {}", admins);
		return admins;
	}

	@Override
	public List<AdminDto> findAdminByAddressPincode(Integer pincode) {
		log.info("findAdminByAddressPincode() -> | Pincode : {}", pincode);
		List<AdminDto> admins = adminDao.findAdminByAddressPincode(pincode);
		log.info("findAdminByAddressPincode() -> | Admins By Pincode : {}", admins);
		return admins;
	}

	@Override
	public AdminDto findAdminByMobileNumber(String mobileNumber) {
		log.info("findAdminByMobileNumber() -> | Mobile Number : {}", mobileNumber);
		AdminDto admin = adminDao.findAdminByMobileNumber(mobileNumber);
		log.info("findAdminByMobileNumber() -> | Admin By Mobile Number : {}", mobileNumber);
		return admin;
	}

	//==========================Change Admin Password Method=======================
	
	@Override
	public void changePassword(String email, String newPassword) {
		log.info("changePassword() -> | Before Change Password : ");
		adminDao.changePassword(email, newPassword);
		log.info("changePassword() -> | After Change Password : ");
	}

	//===========================Update Admin Methods========================
	
	@Override
	public AdminDto updateAdminById(String id, AdminDto admin) {
		log.info("updateAdminById() -> | Before Update By Id : {}", admin);
		AdminDto updatedAdmin = adminDao.updateAdminById(id, admin);
		log.info("updateAdminById() -> | After Update By Id : {}", admin);
		return updatedAdmin;
	}

	@Override
	public AdminDto updateAdminByEmail(String email, AdminDto admin) {
		log.info("updateAdminByEmail() -> | Before Update By Email : {}", admin);
		AdminDto updatedAdmin = adminDao.updateAdminByEmail(email, admin);
		log.info("updateAdminByEmail() -> | After Update By Email : {}", admin);
		return updatedAdmin;
	}

	@Override
	public AdminDto updateAdminByMobileNumber(String mobileNumber, AdminDto admin) {
		log.info("updateAdminByMobileNumber() -> | Before Update By Mobile Number : {}", admin);
		AdminDto updatedAdmin = adminDao.updateAdminByMobileNumber(mobileNumber, admin);
		log.info("updateAdminByMobileNumber() -> | After Update By Mobile Number : {}", admin);
		return updatedAdmin;
	}

	//=========================Delete Admin Methods==============================
	
	@Override
	public void deleteAdminByEmail(String email) {
		log.info("deleteAdminByEmail() -> | Delete By Email : {}", email);
		adminDao.deleteAdminByEmail(email);
		log.info("deleteAdminByEmail() -> | Deleted By Email : {}", email);
	}

	@Override
	public void deleteAdminById(String id) {
		log.info("deleteAdminByEmail() -> | Delete By Id : {}", id);
		adminDao.deleteAdminById(id);
		log.info("deleteAdminByEmail() -> | Delete By Id : {}", id);
	}

	@Override
	public void deleteAdminByMobileNumber(String mobileNumber) {
		log.info("deleteAdminByEmail() -> | Delete By Mobile Number : {}", mobileNumber);
		adminDao.deleteAdminByMobileNumber(mobileNumber);
		log.info("deleteAdminByEmail() -> | Delete By Mobile Number : {}", mobileNumber);
	}
}
