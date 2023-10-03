package com.maveric.training.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.maveric.training.Model.Student;

	public interface UserRepository  extends CrudRepository<Student,String> {

		Optional<Student> findByNameAndPassword(String name, String Password);
	}


