package com.blog.userInfo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.userInfo.entity.UserDetails;
import com.blog.userInfo.exception.NotFound;
import com.blog.userInfo.repository.UserRepository;
import com.blog.userInfo.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails create(UserDetails user) {
		user.setId(UUID.randomUUID().toString());
		return userRepository.save(user);
	}

	@Override
	public List<UserDetails> getAll() {

		return userRepository.findAll();
	}

	@Override
	public String deleteById(int id) throws NotFound {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			return "user deleted";
		} else {
			throw new NotFound("User  Not Found with id: " + id);
		}
	}

	@Override
	public UserDetails getById(int id) throws NotFound {
		if (userRepository.findById(id).isPresent()) {
			Optional<UserDetails> optional = userRepository.findById(id);
			return optional.get();
		} else {
			throw new NotFound("User Not Found With id: " + id);
		}
	}

	@Override
	public UserDetails update(UserDetails userDetails, int id) {

		UserDetails details = userRepository.findById(id).orElse(null);

		if (details != null) {
			details.setName(userDetails.getName());
			details.setEmail(userDetails.getEmail());
			details.setPassword(userDetails.getPassword());
			details.setPhoneNo(userDetails.getPhoneNo());
			details.setAddress(userDetails.getAddress());
			details.setImagePath(userDetails.getImagePath());
			details.setReview(userDetails.getReview());

			userRepository.save(details);
		}

		return details;
	}

	//**************************************************************//
	
	
	@Override
	public List<UserDetails> findByName(String name) throws NotFound {

		List<UserDetails> list = userRepository.findByName(name);

		if (list.isEmpty()) {
			throw new NotFound("User not found");
		}
		return list;
	}

	@Override
	public List<UserDetails> findByCity(String city) throws NotFound {
		List<UserDetails> list = userRepository.findByCity(city);
		
		if(list.isEmpty()) {
			throw new NotFound(" No Records");
		}
		return list;
	}

	@Override
	public List<UserDetails> findByState(String state) throws NotFound {
		List<UserDetails> list = userRepository.findByState(state);
		if(list.isEmpty()) {
			throw new NotFound("No Records");
		}
		 
		return list;
	}

	@Override
	public UserDetails findByEmail(String email) throws NotFound {
		//UserDetails userDetails =userRepository.findByEmail(email);
		UserDetails details = userRepository.findByEmail(email);
		
		if(details == null) {
			throw new NotFound("No Records");
		}
		return details;
		
	}

	@Override
	public UserDetails findByPhoneNo(long phoneNo) throws NotFound {
		UserDetails details = userRepository.findByPhoneNo(phoneNo);
		if(details == null) {
			throw new NotFound("No records");
		}
		return details;
	}
	
	
	
	
}
