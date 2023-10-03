package com.maveric.projectrest.serviceimpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

import com.maveric.projectrest.Employee.Employee;
import com.maveric.projectrest.emprepo.Emprepo;
import com.maveric.projectrest.service.EmpService;


@Service
public abstract class EmpServiceimpl implements EmpService {

	@Autowired
	private Emprepo emprepo;
	
	@Override
	public Employee createEmployee(Employee emp) {
		 return emprepo.save(emp);
	}
	
	 
	    public Employee getEmployeeById(Long empId) {
	        Optional<Employee> optionalEmployee = emprepo.findById(empId);
	        return optionalEmployee.get();
	    }
	 
	 @Override
	    public List<Employee> getAllEmployee() {
	        return emprepo.findAll();
	    }
	 
	 
//	    public Employee updateEmployee(Employee emp) {
//	        Employee existingUser = Emprepo.findById(Employee.getId()).get();
//	        existingUser.setFirstName(Employee.getFirstName());
//	        existingUser.setLastName(Employee.getLastName());
//	        existingUser.setEmail(Employee.getEmail());
//	        Employee updatedUser = emprepo.save(existingUser);
//	        return updatedUser;
//	    }

	    @Override
	    public void deleteEmployee(Long empId) {
	    	emprepo.deleteById(empId);
	    }
	
	
}
