package com.maveric.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maveric.api.service.Studentservice;
import com.maveric.api.model.Student;

@ComponentScan
@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private Studentservice studentservice;
	
	@GetMapping (value= "/student")
	
	public List<Student> get(){
		return studentservice.get();
	}
	
	@PostMapping(value = "/post")
	public Student save(@RequestBody Student studentobj) {
		studentservice.save(studentobj);
		return studentobj;
	}
	
    @GetMapping (value= "/student/{id}")
	
	public Student get(@PathVariable int id){
		return studentservice.get(id);
		
	}
    
//    @GetMapping(value = "/student/{id}")
//    public ResponseEntity<Student> get(@PathVariable int id) {
//        Student student = studentservice.get(id);
//
//        if (student == null) {
//            String errorMessage = "Student with id " + id + " does not exist.";
////            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(student, HttpStatus.OK);
//    }
    
    @DeleteMapping(value= "/student/{id}")
	
   	public String delete(@PathVariable int id){
   		 studentservice.delete(id);
   		 return "Employee has been deleted with id"+id;
   		
   		
   	}
	
}
