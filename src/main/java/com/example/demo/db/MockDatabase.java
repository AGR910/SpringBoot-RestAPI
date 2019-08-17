package com.example.demo.db;

import java.util.List;

import com.example.demo.models.User;

public class MockDatabase {
	private final List<User> users;
	
	public MockDatabase(List<User> users) {
		this.users = users;
	}
	
	public List<User> getUsers() {
		return this.users;
	}	
}
