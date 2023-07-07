package com.blog.Dao;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.dto.OwnerDto;
import com.blog.entity.Owner;
import com.blog.repository.OwnerRepository;

@Service
public class OwnerDaoImpl implements OwnerDao{

	
	private final OwnerRepository ownerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	public OwnerDaoImpl (OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	

	@Override
	public Owner create(Owner owner) {
		
		owner.setId(UUID.randomUUID().toString());
		String encode = passwordEncoder.encode(owner.getPassword());
		owner.setPassword(encode);
		owner.setRole("ROLE_OWNER");
		
		if(emailOrMobileNoExist(owner)) {
			throw new IllegalArgumentException("Email or MobileNo Already Exists");
		}
		return ownerRepository.save(owner);
	}

	@Override
	public OwnerDto getById(String id) {
		Owner findById = ownerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No user found"));
		OwnerDto dto = modelMapper.map(findById, OwnerDto.class);
		return dto;
	}

	@Override
	public OwnerDto update(String id, Owner owner) {
		Owner admin = ownerRepository.findById(id).orElseThrow(()->  new IllegalArgumentException("Owner not found"));
		
			admin.setName(owner.getName());
			admin.setEmail(owner.getEmail());
			admin.setMobileNo(owner.getMobileNo());
			admin.setPassword(owner.getPassword());
			admin.setRole(owner.getRole());
			
			ownerRepository.save(admin);
			
			OwnerDto ownerDto = modelMapper.map(admin, OwnerDto.class);


		
		return ownerDto;		

	}

	@Override
	public String delete(String id) {
		if(ownerRepository.findById(id).isPresent()) {
			ownerRepository.deleteById(id);
			return "Owner Data has been Deleted Successfully";
		}
		return null;
		
		
	}

	@Override
	public OwnerDto findByEmail(String email) {
		Owner owner = ownerRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Owner not found"));
		OwnerDto dto = modelMapper.map(owner, OwnerDto.class);
		return dto;
	}

	@Override
	public OwnerDto findBymobileNo(String mobileNo) {
		Owner owner = ownerRepository.findByMobileNo(mobileNo).orElseThrow(()-> new IllegalArgumentException("Found"));
		OwnerDto dto = modelMapper.map(owner, OwnerDto.class);
		return dto;
	}

	@Override
	public boolean emailOrMobileNoExist(Owner owner) {
	return	ownerRepository.findByEmail(owner.getEmail()).isPresent() 
		|| ownerRepository.findByMobileNo(owner.getMobileNo()).isPresent();
		
	}

	@Override
	public void changePassword(String email, String password) {
		Owner owner = ownerRepository.findByEmail(email).orElseThrow(()-> new IllegalArgumentException("Incorrect Email"));
		owner.setPassword(password);
		ownerRepository.save(owner);
		
		
	}

}
