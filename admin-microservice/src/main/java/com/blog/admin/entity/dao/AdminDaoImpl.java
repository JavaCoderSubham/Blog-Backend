package com.blog.admin.entity.dao;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.admin.entity.Admin;
import com.blog.admin.entity.AdminDto;
import com.blog.admin.exceptions.AadharAlreadyExistException;
import com.blog.admin.exceptions.AdminNotFoundException;
import com.blog.admin.exceptions.EmailOrMobileAlreadyExistException;
import com.blog.admin.repository.AdminRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder encoder;

	// Create Admin
	@Override
	public Admin createAdmin(Admin admin) {
		log.info("create(Admin) -> | Request Subscribe : {}", admin);
		admin.setId(UUID.randomUUID().toString());
		log.info("create(Admin) -> | After Set Id Admin : {}", admin);
		admin.setRole("ROLE_ADMIN");
		log.info("create(Admin) -> | After Set Role Admin : {}", admin);
		if (emailOrMobileAlreadyExist(admin)) {
			throw new EmailOrMobileAlreadyExistException();
		}
		if (aadharAlreadyExist(admin)) {
			throw new AadharAlreadyExistException();
		}
		admin.setPassword(encoder.encode(admin.getPassword()));
		Admin save = adminRepository.save(admin);
		log.info("create(Admin -> | Created Admin : {}", admin);
		return save;
	}

	// Find All Admins
	@Override
	public List<AdminDto> findAllAdmins() {
		log.info("getAllAdmins() -> | ");
		List<Admin> list = adminRepository.findAll();
		log.info("getAllAdmins() -> | Admin List : {}", list);
		List<AdminDto> adminDtos = list.stream().map(dto -> modelMapper.map(list, AdminDto.class))
				.collect(Collectors.toList());
		log.info("getAllAdmins() -> | AdminDto List : {}", adminDtos);
		return adminDtos;
	}

	// Find Admin By Email
	@Override
	public AdminDto findAdminByEmail(String email) {
		log.info("findAdminByEmail() -> | {}", email);
		Admin optionalAdmin = adminRepository.findAdminByEmail(email).orElseThrow(() -> new AdminNotFoundException());
		log.info("findAdminByEmail() -> | Admin : {}", optionalAdmin);
		AdminDto adminDto = modelMapper.map(optionalAdmin, AdminDto.class);
		log.info("findAdminByEmail() -> | AdminDto : {}", adminDto);
		return adminDto;
	}

	// Find Admin By Id
	@Override
	public AdminDto findAdminById(String id) {
		log.info("findAdminById() -> | {}", id);
		Admin optionalAdmin = adminRepository.findById(id).orElseThrow(() -> new AdminNotFoundException());
		log.info("findAdminById() -> | Admin : {}", optionalAdmin);
		AdminDto adminDto = modelMapper.map(optionalAdmin, AdminDto.class);
		log.info("findAdminById() -> | AdminDto : {}", adminDto);
		return adminDto;
	}

	// Find Admin By Aadhar
	@Override
	public AdminDto findAdminByAadhar(String aadharNumber) {
		log.info("findAdminByAadhar() -> | {}", aadharNumber);
		Admin optionalAdmin = adminRepository.findAdminByAadharNumber(aadharNumber)
				.orElseThrow(() -> new AdminNotFoundException());
		log.info("findAdminByAadhar() -> | Admin : {}", optionalAdmin);
		AdminDto adminDto = modelMapper.map(optionalAdmin, AdminDto.class);
		log.info("findAdminByAadhar() -> | AdminDto : {}", adminDto);
		return adminDto;
	}

	// Find Admin By Mobile Number
	@Override
	public AdminDto findAdminByMobileNumber(String mobileNumber) {
		log.info("findAdminByMobileNumber() -> | {}", mobileNumber);
		Admin optionalAdmin = adminRepository.findAdminByMobileNumber(mobileNumber)
				.orElseThrow(() -> new AdminNotFoundException());
		log.info("findAdminByMobileNumber() -> | Admin : {}", optionalAdmin);
		AdminDto adminDto = modelMapper.map(optionalAdmin, AdminDto.class);
		log.info("findAdminByMobileNumber() -> | AdminDto : {}", adminDto);
		return adminDto;
	}

	// Find Admin By AddressCity
	@Override
	public List<AdminDto> findAdminByAddressCity(String city) {
		log.info("findAdminByAddressCity() -> | {}", city);
		List<Admin> admins = adminRepository.findByAddressCity(city);
		log.info("findAdminByAddressCity() -> | Admin : {}", admins);
		List<AdminDto> adminDtos = admins.stream().map(dto -> modelMapper.map(admins, AdminDto.class))
				.collect(Collectors.toList());
		log.info("findAdminByAddressCity() -> | AdminDto : {}", adminDtos);
		return adminDtos;
	}

	// Find Admin By Address State
	@Override
	public List<AdminDto> findAdminByAddressState(String state) {
		log.info("findAdminByAddressState() -> | {}", state);
		List<Admin> admins = adminRepository.findByAddressCity(state);
		log.info("findAdminByAddressState() -> | Admin : {}", admins);
		List<AdminDto> adminDtos = admins.stream().map(dto -> modelMapper.map(admins, AdminDto.class))
				.collect(Collectors.toList());
		log.info("findAdminByAddressState() -> | AdminDto : {}", adminDtos);
		return adminDtos;
	}

	// Find Admin By Address Pincode
	@Override
	public List<AdminDto> findAdminByAddressPincode(Integer pincode) {
		log.info("findAdminByAddressPincode() -> | {}", pincode);
		List<Admin> admins = adminRepository.findByAddressPincode(pincode);
		log.info("findAdminByAddressPincode() -> | Admin : {}", admins);
		List<AdminDto> adminDtos = admins.stream().map(dto -> modelMapper.map(admins, AdminDto.class))
				.collect(Collectors.toList());
		log.info("findAdminByAddressPincode() -> | AdminDto : {}", adminDtos);
		return adminDtos;
	}

	// Change Password
	@Override
	public void changePassword(String email, String newPassword) {
		log.info("changePassword() -> | {}", email);
		Admin admin = adminRepository.findAdminByEmail(email).orElseThrow(() -> new AdminNotFoundException());
		log.info("changePassword() -> | Admin By Email : {}", admin);
		admin.setPassword(newPassword);
		log.info("changePassword() -> | New Password : {}", email);
		adminRepository.save(admin);
	}

	private boolean emailOrMobileAlreadyExist(Admin admin) {
		return adminRepository.findAdminByEmail(admin.getEmail()).isPresent()
				| adminRepository.findAdminByMobileNumber(admin.getMobileNumber()).isPresent();
	}

	private boolean aadharAlreadyExist(Admin admin) {
		return adminRepository.findAdminByAadharNumber(admin.getAadharNumber()).isPresent();
	}

	// Update Admin By Id
	@Override
	public AdminDto updateAdminById(String id, AdminDto updatedAdminDto) {
		log.info("updateAdminById() -> | ID : {}", id);
		Admin admin = adminRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Admin not found"));
		log.info("updateAdminById() -> | Admin Before Update : {}", admin);
		// Update the allowed fields
		admin.setName(updatedAdminDto.getName());
		admin.setEmail(updatedAdminDto.getEmail());
		admin.setMobileNumber(updatedAdminDto.getMobileNumber());
		admin.setAddress(updatedAdminDto.getAddress());

		admin = adminRepository.save(admin);
		log.info("updateAdminById() -> | Admin After Update : {}", admin);
		// Convert Admin entity to AdminDto
		AdminDto adminDto = modelMapper.map(admin, AdminDto.class);
		log.info("updateAdminById() -> | AdminDto After Update : {}", admin);

		return adminDto;
	}

	// Update Admin By Email
	@Override
	public AdminDto updateAdminByEmail(String email, AdminDto updatedAdminDto) {
		log.info("updateAdminByEmail() -> | Email : {}", email);
		Admin admin = adminRepository.findAdminByEmail(email)
				.orElseThrow(() -> new IllegalArgumentException("Admin not found"));
		log.info("updateAdminByEmail() -> | Admin Before Update : {}", admin);
		// Update the allowed fields
		admin.setName(updatedAdminDto.getName());
		admin.setEmail(updatedAdminDto.getEmail());
		admin.setMobileNumber(updatedAdminDto.getMobileNumber());
		admin.setAddress(updatedAdminDto.getAddress());

		admin = adminRepository.save(admin);
		log.info("updateAdminByEmail() -> | Admin After Update : {}", admin);
		// Convert Admin entity to AdminDto
		AdminDto adminDto = modelMapper.map(admin, AdminDto.class);
		log.info("updateAdminByEmail() -> | AdminDto After Update : {}", admin);
		return adminDto;
	}

	// Update Admin By Mobile Number
	@Override
	public AdminDto updateAdminByMobileNumber(String mobileNumber, AdminDto updatedAdminDto) {
		log.info("updateAdminByMobileNumber() -> | Mobile Number : {}", mobileNumber);
		Admin admin = adminRepository.findAdminByMobileNumber(mobileNumber)
				.orElseThrow(() -> new IllegalArgumentException("Admin not found"));
		log.info("updateAdminByMobileNumber() -> | Admin Before Update : {}", admin);
		// Update the allowed fields
		admin.setName(updatedAdminDto.getName());
		admin.setEmail(updatedAdminDto.getEmail());
		admin.setMobileNumber(updatedAdminDto.getMobileNumber());
		admin.setAddress(updatedAdminDto.getAddress());

		admin = adminRepository.save(admin);
		log.info("updateAdminByMobileNumber() -> | Admin After Update : {}", admin);
		// Convert Admin entity to AdminDto
		AdminDto adminDto = modelMapper.map(admin, AdminDto.class);
		log.info("updateAdminByMobileNumber() -> | AdminDto After Update : {}", admin);
		return adminDto;
	}

	// Delete Admin By Email
	@Override
	public void deleteAdminByEmail(String email) {
		log.info("delete(String) -> | Email : {}", email);
		adminRepository.deleteByEmail(email);
		log.info("delete(String) -> | Deleted...Email : {}", email);
	}

	// Delete Admin By Id
	@Override
	public void deleteAdminById(String id) {
		log.info("delete(String) -> | Id : {}", id);
		adminRepository.deleteById(id);
		log.info("delete(String) -> | Deleted...Id : {}", id);
	}

	// Delete Admin By Mobile Number
	@Override
	public void deleteAdminByMobileNumber(String mobileNumber) {
		log.info("delete(String) -> | Mobile Number : {}", mobileNumber);
		adminRepository.deleteByMobileNumber(mobileNumber);
		log.info("delete(String) -> | Deleted...Mobile Number : {}", mobileNumber);
	}
}
