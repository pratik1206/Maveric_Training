package com.maveric.api.service;

import java.util.List;

import com.maveric.api.model.Student;

public interface Studentservice {

   List<Student> get();
	
	Student get(int id);
	
	void save(Student student);
	
	void delete(int id);
}
