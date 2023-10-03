package com.maveric.training.org;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentManagement {
	   public static void main(String[] args) {
		      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		      StudentJdbcTemplate studentJDBCTemplate = 
		      (StudentJdbcTemplate)context.getBean("studentJDBCTemplate");
		      
		      System.out.println("------Records Creation--------" );
		      studentJDBCTemplate.create("EShan",11);
		      studentJDBCTemplate.create("Tanish", 2);
		      studentJDBCTemplate.create("Rajesh", 15);

		      System.out.println("------Listing Multiple Records--------" );
		      List<Student> students = studentJDBCTemplate.listStudents();
		      for (Student record : students) {
		         System.out.print("ID : " + record.getSid() );
		         System.out.print(", Name : " + record.getSname() );
		         System.out.println(", Age : " + record.getAge());
		      }
		      System.out.println("----Updating Record with ID = 2 -----" );
		      studentJDBCTemplate.update(2, 20);

		      System.out.println("----Listing Record with ID = 2 -----" );
		      Student student = studentJDBCTemplate.getStudent(2);
		      System.out.print("ID : " + student.getSid() );
		      System.out.print(", Name : " + student.getSname() );
		      System.out.println(", Age : " + student.getAge());
			  
		   }
}
