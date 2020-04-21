package com.revature.minifullstack.controllers;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.minifullstack.exception.ResourceNotFoundException;
import com.revature.minifullstack.models.Event;
import com.revature.minifullstack.models.User;
import com.revature.minifullstack.repository.UserRepository;
import com.revature.minifullstack.service.TimeInWordsService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TimeInWordsService timeInWordsService;
	
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User loginCredentials) throws ResourceNotFoundException {
		String username = loginCredentials.getUsername();
		String password = loginCredentials.getPassword();
		User user = userRepository.login(username, password);
		
		if(user==null) 
			throw new ResourceNotFoundException("Username and password not recognized");
		return ResponseEntity.ok().body(user);
	
	}
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserByID(@PathVariable(value = "id") int userId)
		throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found with this id: " + userId));
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/user")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/time")
	public Event currentTime() {
		Calendar currentTime = Calendar.getInstance();
		int h = currentTime.get(Calendar.HOUR);
		int m = currentTime.get(Calendar.MINUTE);
		
		Event event = new Event();
		
		event.setTimeInWords(timeInWordsService.timeInWords(h, m));
		
		return event;
		
	}
	

	

}
