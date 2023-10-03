package com.maveric.api.CommandLineRunner;

public class Employee {
 
	private int empid;
	private String Name;
	private String Salary;
	
	
	public Employee(int empid, String name, String salary) {
		super();
		this.empid = empid;
		Name = name;
		Salary = salary;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSalary() {
		return Salary;
	}
	public void setSalary(String salary) {
		Salary = salary;
	}
	
}
