package com.pract.stream;

import java.util.stream.Collectors;
import java.util.*;
import com.pract.stream.Employee2;

public class Practmethod {
	
public static void main(String[] args) {
	List<Employee2> meth = new ArrayList<>();
	
	meth.add(new Employee2(10,"pratik","prat@gmail.com","IT",new Supervisor(101,"Sakshi","sak@gmail.com")));
	meth.add(new Employee2(11,"hrsh","prat@gmail.com","IT",new Supervisor(101,"abhii","sak@gmail.com")));
	meth.add(new Employee2(12,"Samarth","prat@gmail.com","IT",new Supervisor(101,"ankush","sak@gmail.com")));
	meth.add(new Employee2(13,"amrii","prat@gmail.com","IT",new Supervisor(101,"shantanu","sak@gmail.com")));
	meth.add(new Employee2(14,"sakshi","prat@gmail.com","IT",new Supervisor(101,"pooja","sak@gmail.com")));
	meth.add(new Employee2(15,"smita","prat@gmail.com","IT",new Supervisor(101,"umesh","sak@gmail.com")));
	
	

	List<String> emplist = meth.stream().map(employee -> "ID: " + employee.getEid() + ", Name: " + employee.getEname() +
            ", Supervisor ID: " + employee.getSupervisor().getId() +
            ", Supervisor Name: " + employee.getSupervisor().getName()).collect(Collectors.toList());
	
	System.out.println(emplist);
}
}
