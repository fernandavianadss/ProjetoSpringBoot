package com.fernandaviana.projetomongo.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fernandaviana.projetomongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
}
