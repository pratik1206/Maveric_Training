package com.maveric.api.CommandLineRunner;

import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class EmployeeController {

	
	private static ArrayList<Employee> emplist = new ArrayList<Employee>();
    static {
    	emplist.add(new Employee(1,"pratik","25000"));
    	emplist.add(new Employee(2,"sakshi","25000"));
    	emplist.add(new Employee(3,"nikhil","25000"));
    	emplist.add(new Employee(4,"pratik","25000"));
    }
    @GetMapping("/employee1")
   	public String getEmployeeDetails(Model model) {
   	   model.addAttribute("emplist",emplist);
   		return "employee";
   	}
}
