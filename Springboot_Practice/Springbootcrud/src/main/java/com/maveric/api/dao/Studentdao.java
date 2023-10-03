package com.maveric.api.dao;

import java.util.List;

import org.springframework.context.annotation.Bean;

import com.maveric.api.model.Student;

public interface Studentdao {
	@Bean
	
	List<Student> get();
	
	Student get(int id);
	
	void save(Student student);
	
	void delete(int id);
	
}
