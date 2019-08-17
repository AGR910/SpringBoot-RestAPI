package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.db.MockDatabase;
import com.example.demo.models.User;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {
	@Bean
	@Qualifier("name1")
	public String name1() {
		return "alex";
	}
	
	@Bean
	@Qualifier("name2")
	public String name2() {
		return "john";
	}
	
	@Bean
	public MockDatabase provideDatabase() {
		List<User> users = new ArrayList<>();
		users.add(new  User(1, "alex", 10));
		users.add(new  User(2, "john", 11));
		users.add(new  User(3, "evan", 12));
		users.add(new  User(5, "nick", 13));
		users.add(new  User(1, "alex", 10));
		users.add(new  User(6, "alisa", 14));
		return new MockDatabase(users);
	}
}
