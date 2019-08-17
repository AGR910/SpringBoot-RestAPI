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
		return new MockDatabase(users);
	}
}
