package com.devsuperior.hruser.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	private static Logger logger = LoggerFactory.getLogger(UserResource.class);
		
	@Autowired
	private Environment env;
	
	@Autowired
	private UserRepository repository;

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> finsById(@PathVariable long id){
		
		logger.info("findById = " + id );
		
		User obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> finsByEmail(@RequestParam String email){
		
		logger.info("findByEmail = " + email );
		
		User obj = repository.findByEmail(email);
		return ResponseEntity.ok(obj);
	}

}
