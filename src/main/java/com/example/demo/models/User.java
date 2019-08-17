package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@GeneratedValue  // meaning generated automatically the id everytime we create a new object
    @Id		// Tells that private long id is is a field that used for our database like identifier (id).
	private long id;
	private String name;
	private int age;
	
	public User() {
	}
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age= age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public long getId() {
		return this.id;
	}
}
