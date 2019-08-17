package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.MockDatabase;
import com.example.demo.models.User;


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
		final List<User> users = database.getUsers();
		return users;
	}

	@GetMapping("/users/{id}")
	public User userById(@PathVariable int id) {
		final List<User> users = database.getUsers();
		return users.get(id - 1);
	}
}


