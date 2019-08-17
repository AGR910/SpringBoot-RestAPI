package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.db.MockDatabase;
import com.example.demo.models.User;

import static java.util.Arrays.asList;

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
		return new MockDatabase(
			asList(
					new  User(1, "alex", 10),
					new  User(2, "john", 11),
					new  User(3, "evan", 12),
					new  User(5, "nick", 13),
					new  User(6, "alisa", 14)
			)
		);
	}
}
