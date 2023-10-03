package com.maveric.training.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Student {
	 @Id
	   private int id;
	   private String name;
	   private String email;
	   private String department;
	   private String Courses;
	   private String password;
	   
	   public Student() {
		   super();
		   }
	   public Student(int id, String name, String email, String department, String courses, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		Courses = courses;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCourses() {
		return Courses;
	}
	public void setCourses(String courses) {
		Courses = courses;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department + ", Courses="
				+ Courses + ", password=" + password + "]";
	}
	
		
	   
}
