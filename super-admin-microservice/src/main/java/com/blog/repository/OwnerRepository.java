package com.blog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.blog.dto.OwnerDto;


@Repository
public interface OwnerRepository extends MongoRepository<OwnerDto, String>{



	

	
}
