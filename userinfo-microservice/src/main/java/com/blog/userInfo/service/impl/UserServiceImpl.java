package com.blog.userInfo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.userInfo.entity.UserDetails;
import com.blog.userInfo.exception.NotFound;
import com.blog.userInfo.repository.UserRepository;
import com.blog.userInfo.service.UserService;



@Service
public class UserServiceImpl implements UserService{
	
	
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails create(UserDetails user) {
		
		return userRepository.save(user);
	}

	@Override
	public List<UserDetails> getAll() {
		
		return userRepository.findAll();
	}

	@Override
	public String deleteById(int id) throws NotFound {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			return "user deleted";
		}else {
			throw new NotFound("User  Not Found with id: "+id);
		}
	}

	@Override
	public UserDetails getById(int id) {
		 Optional<UserDetails > optional = userRepository.findById(id);
		return optional.get();
	}

}
