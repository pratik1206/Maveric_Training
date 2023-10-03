package com.maveric.projectrest.emprepo;


	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.maveric.projectrest.Employee.Employee;

	@Repository
	public interface Emprepo extends JpaRepository<Employee, Long> {

	}


