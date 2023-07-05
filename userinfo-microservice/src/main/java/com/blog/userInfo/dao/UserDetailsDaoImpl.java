package com.blog.userInfo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.blog.userInfo.dto.UserInfoDto;
import com.blog.userInfo.entity.UserInfo;
import com.blog.userInfo.entity.UserProjectionEmail;
import com.blog.userInfo.entity.UserProjectionPhoneNo;
import com.blog.userInfo.exception.EmailOrPhoneNumberAlreadyExistException;
import com.blog.userInfo.exception.RecordNotFound;
import com.blog.userInfo.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserDetailsDaoImpl implements UserDetailsDao {

	@Autowired
	private UserRepository userRepository;

	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private PasswordEncoder passwordEncoder;
  
	@Override
	public UserInfo create(UserInfo user) {
		log.info("============ Create UserDetailsDaoImpl Started ============");
		user.setId(UUID.randomUUID().toString());
		String encoded = passwordEncoder.encode(user.getPassword());
		log.info("create(String)-> | password : {}", encoded);
		user.setPassword(encoded);
		log.info("[[ password encoded successfully]]");
		user.setRole("ROLE_USER");

		if (emailOrPhoneNoExist(user)) {
			throw new EmailOrPhoneNumberAlreadyExistException();
		}
		log.info("============ Create UserDetailsDaoImpl Ended ============");
		return userRepository.save(user);
	}

	@Override
	public List<UserInfoDto> getAll() {
		log.info("============ getAll UserDetailsDaoImpl Started ============");
		List<UserInfo> info = userRepository.findAll();

		List<UserInfoDto> userInfoDtos = new ArrayList<>();
		for (UserInfo userInfo : info) {

			UserInfoDto userInfoDto = new UserInfoDto();
			userInfoDto.setId(userInfo.getId());
			userInfoDto.setName(userInfo.getName());
			userInfoDto.setEmail(userInfo.getEmail());
			userInfoDto.setPhoneNo(userInfo.getPhoneNo());
			userInfoDto.setRole(userInfo.getRole());
			userInfoDto.setAddress(userInfo.getAddress());
			userInfoDto.setReview(userInfo.getReview());

			userInfoDtos.add(userInfoDto);
		}
		log.info("getAll()-> | get : {}", info);
		log.info("============ getAll UserDetailsDaoImpl Ended ============");
		return userInfoDtos;
	}

	@Override
	public String deleteById(String id) throws RecordNotFound {
		log.info("============ deleteBYId UserDetailsDaoImpl Started ============");
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			log.info("deleteByid(String)-> | id : {}", id);
			log.info("============ deleteById UserDetailsDaoImpl Ended ============");
			return "user deleted";
		} else {
			throw new RecordNotFound();
		}
	}

	@Override
	public UserInfoDto getById(String id) throws RecordNotFound {
		log.info("============ getById UserDetailsDaoImpl Started ============");
		UserInfo userInfo = userRepository.findById(id).orElseThrow(() -> new RecordNotFound());

		UserInfoDto userInfoDto = new UserInfoDto();
		userInfoDto.setId(userInfo.getId());
		userInfoDto.setName(userInfo.getName());
		userInfoDto.setEmail(userInfo.getEmail());
		userInfoDto.setPhoneNo(userInfo.getPhoneNo());
		userInfoDto.setImagePath(userInfo.getImagePath());
		userInfoDto.setRole(userInfo.getRole());
		userInfoDto.setAddress(userInfo.getAddress());
		userInfoDto.setReview(userInfo.getReview());
		log.info("============ getById UserDetailsDaoImpl Ended ============");
		return userInfoDto;
	}

	@Override
	public UserInfo update(UserInfo userDetails, String id) {
		log.info("============ update UserDetailsDaoImpl Started ============");
		UserInfo details = userRepository.findById(id).orElse(null);
		log.info("update(String)-> | Id : {}", id);
		if (details != null) {
			details.setName(userDetails.getName());
			details.setEmail(userDetails.getEmail());
			details.setPassword(userDetails.getPassword());
			details.setPhoneNo(userDetails.getPhoneNo());
			details.setAddress(userDetails.getAddress());
			details.setImagePath(userDetails.getImagePath());
			details.setReview(userDetails.getReview());
			log.info("=====Updated User in userDeatilsDaoImpl=====");
			userRepository.save(details);
			log.info("============ update UserDetailsDaoImpl Ended ============");

		}

		return details;
	}

	// **************************************************************//

	@Override
	public List<UserInfoDto> findByName(String name) throws RecordNotFound {
		log.info("============ findByName UserDetailsDaoImpl Started ============");
		List<UserInfo> userInfos = userRepository.findByName(name);

		log.info("findByname(String)-> | name : {}", name);

		if (userInfos.isEmpty()) {

			throw new RecordNotFound();
		} else {
			
			List<UserInfoDto> userInfoDtos = new ArrayList<>();
			for (UserInfo userInfo : userInfos) {

				UserInfoDto userInfoDto = new UserInfoDto();
				userInfoDto.setId(userInfo.getId());
				userInfoDto.setName(userInfo.getName());
				userInfoDto.setEmail(userInfo.getEmail());
				userInfoDto.setPhoneNo(userInfo.getPhoneNo());
				userInfoDto.setRole(userInfo.getRole());
				userInfoDto.setAddress(userInfo.getAddress());
				userInfoDto.setReview(userInfo.getReview());

				userInfoDtos.add(userInfoDto);
				log.info("============ findByName UserDetailsDaoImpl Ended ============");

			}

			return userInfoDtos;
		}
	}

	@Override
	public List<UserInfoDto> findByAddressCity(String city) throws RecordNotFound {
		// UserInfo userInfo = new UserInfo();
		log.info("============ findByAddressCity UserDetailsDaoImpl Started ============");
		List<UserInfo> list = userRepository.findByAddressCity(city);
		log.info("findByAddressCity(String)-> | city : {} ", city);
		if (list.isEmpty()) {
			throw new RecordNotFound();
		} else {
			
			List<UserInfoDto> userInfoDtos = new ArrayList<>();

			for (UserInfo userInfo : userInfos) {

				UserInfoDto userInfoDto = new UserInfoDto();
				userInfoDto.setId(userInfo.getId());
				userInfoDto.setName(userInfo.getName());
				userInfoDto.setEmail(userInfo.getEmail());
				userInfoDto.setPhoneNo(userInfo.getPhoneNo());
				userInfoDto.setRole(userInfo.getRole());
				userInfoDto.setAddress(userInfo.getAddress());
				userInfoDto.setReview(userInfo.getReview());

				userInfoDtos.add(userInfoDto);
				log.info("============ findByName UserDetailsDaoImpl Ended ============");

			}

			return userInfoDtos;
		}
	}

	@Override
	public List<UserInfoDto> findByAddressCity(String city) throws RecordNotFound {
		// UserInfo userInfo = new UserInfo();
		log.info("============ findByAddressCity UserDetailsDaoImpl Started ============");
		List<UserInfo> list = userRepository.findByAddressCity(city);
		log.info("findByAddressCity(String)-> | city : {} ", city);
		if (list.isEmpty()) {
			throw new RecordNotFound();
		} else {
			
			List<UserInfoDto> userInfoDtos = new ArrayList<>();

			for (UserInfo userInfo : list) {

				UserInfoDto userInfoDto = new UserInfoDto();
				userInfoDto.setId(userInfo.getId());
				userInfoDto.setName(userInfo.getName());
				userInfoDto.setEmail(userInfo.getEmail());
				userInfoDto.setPhoneNo(userInfo.getPhoneNo());
				userInfoDto.setRole(userInfo.getRole());
				userInfoDto.setAddress(userInfo.getAddress());
				userInfoDto.setReview(userInfo.getReview());

				userInfoDtos.add(userInfoDto);
				log.info("============ findByAddressCity UserDetailsDaoImpl Ended ============");
			}

			return userInfoDtos;
		}

	}

	@Override
	public List<UserInfoDto> findByAddressState(String state) throws RecordNotFound {
		log.info("============ findByAddressState UserDetailsDaoImpl Started ============");
		List<UserInfo> userInfos = userRepository.findByAddressState(state);
		log.info("findByAddressState(String)-> | state : {}", state);
		if (userInfos.isEmpty()) {
			throw new RecordNotFound();
		} else {
			
			List<UserInfoDto> userInfoDtos = new ArrayList<>();
			for (UserInfo userInfo : userInfos) {

				UserInfoDto userInfoDto = new UserInfoDto();
				userInfoDto.setId(userInfo.getId());
				userInfoDto.setName(userInfo.getName());
				userInfoDto.setEmail(userInfo.getEmail());
				userInfoDto.setPhoneNo(userInfo.getPhoneNo());
				userInfoDto.setRole(userInfo.getRole());
				userInfoDto.setAddress(userInfo.getAddress());
				userInfoDto.setReview(userInfo.getReview());

				userInfoDtos.add(userInfoDto);
				log.info("============ findByAddressState UserDetailsDaoImpl Ended ============");
			}
			return userInfoDtos;
		}
	}

	@Override
	public UserProjectionEmail findByEmail(String email) throws RecordNotFound {
		log.info("============ findByEmail UserDetailsDaoImpl Started ============");

		if (userRepository.findByEmail(email).isPresent()) {
			// Optional<UserInfo> info = userRepository.findByEmail(email);
			UserInfo userInfo = userRepository.findByEmail(email).get();
			UserProjectionEmail projectionEmail = new UserProjectionEmail();
			projectionEmail.setEmail(userInfo.getEmail());
			projectionEmail.setId(userInfo.getId());
			projectionEmail.setName(userInfo.getName());
			// projectionEmail.setPassword(userInfo.getPassword());
			projectionEmail.setRole(userInfo.getRole());
			log.info("findByEmail(String)-> | email : {}", projectionEmail);
			log.info("============ findByEmail UserDetailsDaoImpl Ended ============");

			return projectionEmail;
		} else {
			throw new RecordNotFound();
		}

	}

	@Override
	public UserProjectionPhoneNo findByPhoneNo(String phoneNo) throws RecordNotFound {
		log.info("============ findByPhoneNo UserDetailsDaoImpl Started ============");

		if (userRepository.findByPhoneNo(phoneNo).isPresent()) {
			// Optional<UserInfo> info = userRepository.findByPhoneNo(phoneNo);
			UserInfo userInfo = userRepository.findByPhoneNo(phoneNo).get();
			UserProjectionPhoneNo projectionPhoneNo = new UserProjectionPhoneNo();
			projectionPhoneNo.setId(userInfo.getId());
			projectionPhoneNo.setName(userInfo.getName());
			projectionPhoneNo.setEmail(userInfo.getEmail());
			projectionPhoneNo.setRole(userInfo.getRole());
			log.info("findBYPhoneNo(String)-> | phoneNo : {}", projectionPhoneNo);
			log.info("============ findByPhoneNo UserDetailsDaoImpl Ended ============");

			return projectionPhoneNo;
		} else {
			throw new RecordNotFound();
		}
	}

	@Override
	public boolean emailOrPhoneNoExist(UserInfo userInfo) {
		log.info("============ emailOrPhoneNoExist UserDetailsDaoImpl Started ============");
		log.info("emailOrPhoneNoExist(userInfo)-> | userInfo : {}", userInfo);
		log.info("============ emailOrPhoneNoExist UserDetailsDaoImpl Ended ============");
		return userRepository.findByEmail(userInfo.getEmail()).isPresent()
				|| userRepository.findByPhoneNo(userInfo.getPhoneNo()).isPresent();
	}

	@Override
	public void changePassword(String email, String password) throws RecordNotFound {
		log.info("============ changePassword UserDetailsDaoImpl Started ============");
		UserInfo info = userRepository.findByEmail(email).orElseThrow(() -> new RecordNotFound());
		log.info("changePassword(string)-> | password : {}", info);
		info.setPassword(password);

		userRepository.save(info);
		log.info("============ changePassword UserDetailsDaoImpl Ended ============");
	}

}
