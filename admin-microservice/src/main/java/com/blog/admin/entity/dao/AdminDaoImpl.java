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

@Service
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public Admin createAdmin(Admin admin) {
		admin.setId(UUID.randomUUID().toString());
		admin.setRole("ROLE_ADMIN");
		if (emailOrMobileAlreadyExist(admin)) {
			throw new EmailOrMobileAlreadyExistException();
		}
		if (aadharAlreadyExist(admin)) {
			throw new AadharAlreadyExistException();
		}
		admin.setPassword(encoder.encode(admin.getPassword()));
		Admin save = adminRepository.save(admin);
		return save;
	}
	
	@Override
	public List<AdminDto> findAllAdmins() {
		List<Admin> list = adminRepository.findAll();
		return list.stream().map(dto -> modelMapper.map(list, AdminDto.class)).collect(Collectors.toList());
	}

	@Override
	public AdminDto findAdminByEmail(String email) {
		Admin optionalAdmin = adminRepository.findAdminByEmail(email).orElseThrow(() -> new AdminNotFoundException());
		AdminDto adminDto = modelMapper.map(optionalAdmin, AdminDto.class);
		return adminDto;
	}
	
	@Override
	public AdminDto findAdminById(String id) {
		Admin optionalAdmin = adminRepository.findById(id).orElseThrow(() -> new AdminNotFoundException());
		AdminDto adminDto = modelMapper.map(optionalAdmin, AdminDto.class);
		return adminDto;
	}

	@Override
	public AdminDto findAdminByAadhar(String aadharNumber) {
		Admin optionalAdmin = adminRepository.findAdminByAadharNumber(aadharNumber)
				.orElseThrow(() -> new AdminNotFoundException());
		AdminDto adminDto = modelMapper.map(optionalAdmin, AdminDto.class);
		return adminDto;
	}

	@Override
	public AdminDto findAdminByMobileNumber(String mobileNumber) {
		Admin optionalAdmin = adminRepository.findAdminByMobileNumber(mobileNumber)
				.orElseThrow(() -> new AdminNotFoundException());
		AdminDto adminDto = modelMapper.map(optionalAdmin, AdminDto.class);
		return adminDto;
	}

	@Override
	public List<AdminDto> findAdminByAddressCity(String city) {
		List<Admin> admins = adminRepository.findByAddressCity(city);
		return admins.stream().map(dto -> modelMapper.map(admins, AdminDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<AdminDto> findAdminByAddressState(String state) {
		List<Admin> admins = adminRepository.findByAddressCity(state);
		return admins.stream().map(dto -> modelMapper.map(admins, AdminDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<AdminDto> findAdminByAddressPincode(Integer pincode) {
		List<Admin> admins = adminRepository.findByAddressPincode(pincode);
		return admins.stream().map(dto -> modelMapper.map(admins, AdminDto.class)).collect(Collectors.toList());
	}

	@Override
	public void changePassword(String email, String newPassword) {
		Admin admin = adminRepository.findAdminByEmail(email).orElseThrow(() -> new AdminNotFoundException());
		admin.setPassword(newPassword);
		adminRepository.save(admin);
	}

	private boolean emailOrMobileAlreadyExist(Admin admin) {
		return adminRepository.findAdminByEmail(admin.getEmail()).isPresent()
				| adminRepository.findAdminByMobileNumber(admin.getMobileNumber()).isPresent();
	}

	private boolean aadharAlreadyExist(Admin admin) {
		return adminRepository.findAdminByAadharNumber(admin.getAadharNumber()).isPresent();
	}
	
	@Override
	public AdminDto updateAdminById(String id, AdminDto updatedAdminDto) {
		Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Admin not found"));

        // Update the allowed fields
        admin.setName(updatedAdminDto.getName());
        admin.setEmail(updatedAdminDto.getEmail());
        admin.setMobileNumber(updatedAdminDto.getMobileNumber());
        admin.setAddress(updatedAdminDto.getAddress());

        admin = adminRepository.save(admin);

        // Convert Admin entity to AdminDto
        AdminDto adminDto = modelMapper.map(admin, AdminDto.class);

        return adminDto;
	}

	@Override
	public AdminDto updateAdminByEmail(String email, AdminDto updatedAdminDto) {
		Admin admin = adminRepository.findAdminByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Admin not found"));

        // Update the allowed fields
        admin.setName(updatedAdminDto.getName());
        admin.setEmail(updatedAdminDto.getEmail());
        admin.setMobileNumber(updatedAdminDto.getMobileNumber());
        admin.setAddress(updatedAdminDto.getAddress());

        admin = adminRepository.save(admin);

        // Convert Admin entity to AdminDto
        AdminDto adminDto = modelMapper.map(admin, AdminDto.class);

        return adminDto;
	}

	@Override
	public AdminDto updateAdminByMobileNumber(String mobileNumber, AdminDto updatedAdminDto) {
		Admin admin = adminRepository.findAdminByMobileNumber(mobileNumber)
                .orElseThrow(() -> new IllegalArgumentException("Admin not found"));

        // Update the allowed fields
        admin.setName(updatedAdminDto.getName());
        admin.setEmail(updatedAdminDto.getEmail());
        admin.setMobileNumber(updatedAdminDto.getMobileNumber());
        admin.setAddress(updatedAdminDto.getAddress());

        admin = adminRepository.save(admin);

        // Convert Admin entity to AdminDto
        AdminDto adminDto = modelMapper.map(admin, AdminDto.class);

        return adminDto;
	}

	@Override
	public void deleteAdminByEmail(String email) {
		adminRepository.deleteByEmail(email);
	}
	
	@Override
	public void deleteAdminById(String id) {
		adminRepository.deleteById(id);
	}

	@Override
	public void deleteAdminByMobileNumber(String mobileNumber) {
		adminRepository.deleteByMobileNumber(mobileNumber);
	}
}
