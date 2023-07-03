package com.blog.userInfo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.blog.userInfo.entity.UserInfo;
import com.blog.userInfo.exception.RecordNotFound;
import com.blog.userInfo.repository.UserRepository;



@Component
public class UserDetailsDaoImpl implements UserDetailsDao {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserInfo create(UserInfo user) {
		user.setId(UUID.randomUUID().toString());
		String encoded = passwordEncoder.encode(user.getPassword());
		user.setPassword(encoded);
		user.setRole("ROLE_USER");
		return userRepository.save(user);
	}

	@Override
	public List<UserInfo> getAll() {

	return userRepository.findAll();
	}

	@Override
	public String deleteById(String id) throws RecordNotFound {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			return "user deleted";
		} else {
			throw new RecordNotFound();
		}
	}

	@Override
	public UserInfo getById(String id) throws  RecordNotFound {
		try {
			if (userRepository.findById(id).isPresent()) {
				Optional<UserInfo> optional = userRepository.findById(id);
				return optional.get();
			} else {
				throw new RecordNotFound();
			}
		} catch (RecordNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserInfo update(UserInfo userDetails, String id) {

		UserInfo details = userRepository.findById(id).orElse(null);

		if (details != null) {
			details.setName(userDetails.getName());
			details.setEmail(userDetails.getEmail());
			details.setPassword(userDetails.getPassword());
			details.setPhoneNo(userDetails.getPhoneNo());
//			details.setAddress(userDetails.getAddress());
			details.setImagePath(userDetails.getImagePath());
			details.setReview(userDetails.getReview());

			userRepository.save(details);
		}

		return details;
	}

	//**************************************************************//
	
	
	@Override
	public List<UserInfo> findByName(String name) throws  RecordNotFound {

		List<UserInfo> userInfos = userRepository.findByName(name);
		
		if(userInfos != null) {
			return userInfos;
		}else {
			throw new RecordNotFound();
		}

	}

//	@Override
//	public List<UserInfo> findByCity(String city) throws NotFound {
//		List<UserInfo> list = userRepository.findByCity(city);
//		
//		if(list.isEmpty()) {
//			throw new NotFound(" No Records");
//		}
//		return list;
//	}
//
//	@Override
//	public List<UserInfo> findByState(String state) throws NotFound {
//		List<UserInfo> list = userRepository.findByState(state);
//		if(list.isEmpty()) {
//			throw new NotFound("No Records");
//		}
//		 
//		return list;
//	}

	@Override
	public UserInfo findByEmail(String email) throws RecordNotFound {
		
			if(userRepository.findByEmail(email).isPresent()) {
				Optional<UserInfo> info = userRepository.findByEmail(email);
				return info.get();
		}else {
			throw new RecordNotFound();
		}
		
	}

	@Override
	public UserInfo findByPhoneNo(String phoneNo) throws  RecordNotFound {
		UserInfo details = userRepository.findByPhoneNo(phoneNo);
		if(details == null) {
			throw new RecordNotFound();
		}
		return details;
	}
	
	
}
