package com.maveric.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maveric.api.dao.Studentdao;
import com.maveric.api.model.Student;
@Service

public class Studentserviceimpl implements Studentservice {
	
	@Autowired
	private Studentdao studentdao;
	
	@Transactional
	@Override
	public List<Student> get() {
		return studentdao.get();
	}
	@Transactional
	@Override
	public Student get(int id) {
		return studentdao.get(id);
	}
	@Transactional
	@Override
	public void save(Student student) {
		studentdao.save(student);
	}
	@Transactional
	@Override
	public void delete(int id) {
		studentdao.delete(id);
		
	}

	
}
