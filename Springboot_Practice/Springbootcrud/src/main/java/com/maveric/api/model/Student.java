package com.maveric.api.model;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column	
	private Integer id;
	@Column
	private String name;
	@Column
	private String gender;
	@Column
	private String department;
	@Column
	private Date Dob;
	
//	public Student(Integer iD, String name, String gender, String department, Date dob) {
//		super();
//		id = iD;
//		this.name = name;
//		this.gender = gender;
//		this.department = department;
//		Dob = dob;
//	}

	public Integer getID() {
		return id;
	}

	public void setID(Integer iD) {
		id = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDob() {
		return Dob;
	}

	public void setDob(Date dob) {
		Dob = dob;
	}

	@Override
	public String toString() {
		return "Student [ID=" + id + ", Name=" + name + ", gender=" + gender + ", department=" + department + ", Dob="
				+ Dob + "]";
	}
	
		
	
	

}
