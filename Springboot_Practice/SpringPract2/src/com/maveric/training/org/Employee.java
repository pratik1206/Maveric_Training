package com.maveric.training.org;

public class Employee {
	private int empId;
	private String name;
	private double salary;
	
	public Employee() {
		System.out.println("Default constructor of Employee is called");
		empId=0;
		name="";
		salary=0;
	}
	
	public Employee(int empId, String name, double salary) {
		System.out.println("Parameterised constructor of Employee is called");
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + "]";
}
}
