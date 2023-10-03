package com.pract.stream;

//import com.pract.stream.EmployeeDao;

import java.util.ArrayList;
import java.util.List;

//import com.pract.stream.Employee1;



class DailyCalculator implements SalaryCalculator{
	
	@Override
	public double calculateSalary(double hourlyRate, double hoursWorked) {
		SalaryCalculator salary = (x,y) -> hourlyRate * hoursWorked;
		double calculatesaldaily = salary.calculateSalary(hourlyRate,hoursWorked);
		System.out.println("Daily salary of Employee is "+calculatesaldaily);
		double calculatesal = salary.calculateSalary(hourlyRate,hoursWorked)*7;
//		System.out.println("Weekly salary of Employee is "+calculatesal);
		return calculatesal;
	}
}
	

public class Calculatesalary {
	
	
public static void main(String[] args) {
	
	List<Employee1> emp = new ArrayList<>();
	emp.add(new Employee1("pratik",500,8));
	emp.add(new Employee1("Sakshi",600,9));
	emp.add(new Employee1("Amrita",1000,10));
	emp.add(new Employee1("Harsh",600,10));
	emp.add(new Employee1("Nikhil",500,8));
	emp.add(new Employee1("Smita",900,8));
	System.out.println(emp);
	
//	DailyCalculator daily = new DailyCalculator();
//	daily.calculateSalaries(emp);
	SalaryCalculator dailyCalculator = new DailyCalculator();
	Calculatesalary.calculateSalaries(emp, dailyCalculator);
}
public static void calculateSalaries(List<Employee1> employees, SalaryCalculator calculator) {
    for (Employee1 employee : employees) {
        double salary = calculator.calculateSalary(employee.getHourlyRate(), employee.getHoursWorked());
        System.out.println("Salary for " + employee.getName() + ": " + salary);
    }
}
	
}

