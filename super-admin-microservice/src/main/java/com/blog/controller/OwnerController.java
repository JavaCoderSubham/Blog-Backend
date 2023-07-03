package com.blog.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.OwnerDto;
import com.blog.entity.Owner;
import com.blog.repository.OwnerRepository;


@RestController
@RequestMapping("/superAdmin")
public class OwnerController {

	private final OwnerRepository repository;
	
	
	private static final Logger logger = LoggerFactory.getLogger(OwnerController.class);

	
	@Autowired
	public OwnerController(OwnerRepository repository) {
		this.repository=repository;
	}
	
	@PostMapping("/post")
	public OwnerDto create(@Validated @RequestBody OwnerDto dto) {
		logger.info(" Creating Owner {}" ,dto.getName());
		Owner owner = new Owner();
		owner.setId(dto.getId());
		owner.setName(dto.getName());
		owner.setEmail(dto.getEmail());
		owner.setPassword(dto.getPassword());
		owner.setMobileNo(dto.getMobileNo());
		owner.setRole(dto.getRole());
		
		owner = repository.save(owner);
		return new OwnerDto(owner);
	}
	
	
	@GetMapping("/getsuperAdmin")
    public List<OwnerDto> getData() {
		logger.info("Super Admins Present ....!!!");
        List<Owner> owner = repository.findAll();
        return owner.stream()
                .map(OwnerDto::new)
                .collect(Collectors.toList());
    }
}
