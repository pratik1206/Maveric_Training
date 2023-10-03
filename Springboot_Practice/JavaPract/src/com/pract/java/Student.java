package com.pract.java;

public class Student {
	
	private int id;
	private String Name;
	private int std;
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + Name + ", std=" + std + "]";
	}


	public Student(int id, String name, int std) {
		super();
		this.id = id;
		Name = name;
		this.std=std;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getstd() {
		return std;
	}


	public void setstd(String std) {
		std = std;
	}

	
	public static void main(String[] args) {
		
	}

}
