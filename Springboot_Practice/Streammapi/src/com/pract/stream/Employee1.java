package com.pract.stream;

public class Employee1 {
   private String Name;
   private double hourlyRate;
   private double hoursWorked;
public Employee1(String name, double hourlyRate, double hoursWorked) {
	super();
	Name = name;
	this.hourlyRate = hourlyRate;
	this.hoursWorked = hoursWorked;
}

public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public double getHourlyRate() {
	return hourlyRate;
}
public void setHourlyRate(double hourlyRate) {
	this.hourlyRate = hourlyRate;
}
public double getHoursWorked() {
	return hoursWorked;
}
public void setHoursWorked(double hoursWorked) {
	this.hoursWorked = hoursWorked;
}
@Override
public String toString() {
	return "Employee1 [Name=" + Name + ", hourlyRate=" + hourlyRate + ", hoursWorked=" + hoursWorked + "]";
}
   
}
