package com.maveric.projectrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maveric.projectrest.Employee.Employee;

public interface EmpService {

	Employee createEmployee(Employee emp);
	Employee getEmployeeById(Employee empId);
	List<Employee> getAllEmployee();
	Employee updateEmployee(Employee emp);
	void deleteEmployee(Long empId);

}
