package com.maveric.training.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maveric.training.Model.Student;
import com.maveric.training.repository.UserRepository;


@Service  
public class StudentService {
	@Autowired    
	private UserRepository userRepository;    
	public List<Student> getAllUsers()  
	{    
		List<Student>userRecords = new ArrayList<>();    
		userRepository.findAll().forEach(userRecords::add);    
		return userRecords;    
	}    
	public void addUser(Student userRecord)  
	{    
		userRepository.save(userRecord);    
	}
	public void deleteUser(String id)  
	{    
		userRepository.deleteById(id);    
	}
	public void addUsers(Student userRecord)  
	{    
		userRepository.save(userRecord);    
	}
	
	public Optional<Student> getAllUsersBYId(String id)  
	{    
				return userRepository.findById(id);    
		    
	} 

	
	public boolean checkLogin(String username, String password) {
	    Optional<Student> studentOptional = userRepository.findByNameAndPassword(username, password);
	    return studentOptional.isPresent();
	}
}
