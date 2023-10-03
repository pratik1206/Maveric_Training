package com.maveric.api.CommandLineRunner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MessageController {
	
  
   @GetMapping("/employee")
	public String getEmployeeDetails(Model model) {
	   model.addAttribute("message","This is message from Controller");
		return "employee";
	}
   
   
 
}
