package com.example.demo.models;

public class User {
	private final long id;
	private String name;
	private int age;
	
	public User(long id, String name, int age) {
		this.id = id;
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
