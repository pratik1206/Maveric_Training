package com.maveric.projectrest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maveric.projectrest.Employee.Employee;
import com.maveric.projectrest.service.EmpService;


@RestController
@RequestMapping("/api/employee")

public class Empcontroller {

	@Autowired
	private EmpService empservice;
	
	@PostMapping("/post")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		Employee SavedEmployee = empservice.createEmployee(employee);
		return new ResponseEntity<>(SavedEmployee, HttpStatus.CREATED);
	}
	
	 @GetMapping("{ID}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable("ID") Employee empId){
		 Employee employee = empservice.getEmployeeById(empId);
	        return new ResponseEntity<>(employee, HttpStatus.OK);
	    }
	  @GetMapping
	    public ResponseEntity<List<Employee>> getAllEmployee(){
	        List<Employee> employee = empservice.getAllEmployee();
	        return new ResponseEntity<>(employee, HttpStatus.OK);
	    }
	  @DeleteMapping("{ID}")
	    public ResponseEntity<String> deleteUser(@PathVariable("ID") Long empId){
		  empservice.deleteEmployee(empId);
	        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	    }
}
