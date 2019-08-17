package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.db.MockDatabase;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

import java.util.stream.Stream;

@RestController
public class RootController {
	@Autowired
	@Qualifier("name2")
	String name2;
	
	@Autowired
	@Qualifier("name1")
	String name1; 
	
	@Autowired
	MockDatabase database;
	
	@Autowired
	UserRepository repository;
	
	
	@RequestMapping("/home")	
	public String index() {
		return "Hello, " + name1;
	}
	
	@RequestMapping("/home/some")
	public String index2() {
		return "Hello, " + name2;
	}
	
	@GetMapping("/users")
	public List<User> users() {
		//final List<User> users = database.getUsers();
		//return users;
		final List<User> users = repository.findAll();
		return users;
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> userById(@PathVariable int id) {
		final List<User> users = database.getUsers();
		final Stream<User> stream = users.stream().filter(u -> u.getId() == id);
		final Optional<User> streamUser = stream.findFirst();
		if (streamUser.isPresent()) {
			return new ResponseEntity<User>(streamUser.get(), HttpStatus.OK);
		}
		// 404 Not found
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		repository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> putUserById(@PathVariable int id, @RequestBody User user) {
		final Optional<User> streamUser = database.getUsers()
				.stream()
				.filter(u -> u.getId() == id)
				.findFirst();
		if (streamUser.isPresent()) {
			final User userDb = streamUser.get();
			userDb.setName(user.getName());
			userDb.setAge(user.getAge());
			return new ResponseEntity<User>(userDb, HttpStatus.OK);
		}
		// 404 Not found
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
	}
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, String>> deleteUserById(@PathVariable int id){
		database.getUsers().removeIf(u -> u.getId() == id);
		Map<String, String> body = new HashMap<>();
		body.put("message", "your object with id = " + id + " removed");
		return new ResponseEntity<Map<String, String>>(body, HttpStatus.OK);
	}
}


