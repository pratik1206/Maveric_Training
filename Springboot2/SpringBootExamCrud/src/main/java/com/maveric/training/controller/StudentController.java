package com.maveric.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.maveric.training.Model.Student;
import com.maveric.training.Model.Response;
import com.maveric.training.service.StudentService;

@Controller 
public class StudentController {
	@Autowired    
	private StudentService studentservice;     
	  
	@GetMapping("/")
    public String getAllUsers(Model model) {
        List<Student> students = studentservice.getAllUsers();
        model.addAttribute("students", students);
        return "index"; // Return the template name without ".html" extension
    }
    
    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("student", new Student());
        return "add";
    }

    @PostMapping("/save")
    public String addUser(@ModelAttribute Student student) {
    	studentservice.addUser(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable String id, Model model) {
        Student student = studentservice.getAllUsersBYId(id).orElse(null);
        if (student == null) {
            return "redirect:/";
        }
        model.addAttribute("student", student);
        return "edit";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute Student student) {
    	studentservice.addUser(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
    	studentservice.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("student", new Student());
        return "login";
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute Student student, Model model) {
//        boolean isValidUser = studentservice.checkLogin(student.getName(), student.getpassword());
//
//        if (isValidUser) {
//            // Successful login, redirect to student list
//            return "redirect:/";
//        } else {
//            model.addAttribute("errorMessage", "Invalid username or password");
//            return "login";
//        }
//    }
    @PostMapping("/login")
    public String login(@ModelAttribute Student student, Model model) {
        boolean isValidUser = studentservice.checkLogin(student.getName(), student.getpassword());

        if (isValidUser) {
            // Successful login, redirect to student list or any other page
            return "redirect:/";
        } else {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "login";
        }
    }

}
