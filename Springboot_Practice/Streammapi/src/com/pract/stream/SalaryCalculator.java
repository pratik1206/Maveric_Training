package com.pract.stream;
@FunctionalInterface
public interface SalaryCalculator {
	double calculateSalary(double hourlyRate,double hoursWorked);
}
