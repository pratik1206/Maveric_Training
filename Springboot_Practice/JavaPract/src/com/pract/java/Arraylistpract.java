package com.pract.java;
import java.util.*;
import java.util.stream.Collectors;

public class Arraylistpract {

	public static void main(String[] args) {
	
		List<Student> some = new ArrayList<>();
		
		some.add(new Student(10,"pratik",12));
		some.add(new Student(20,"Amrita",11));
		some.add(new Student(10,"pratik",10));
			  
		List<Student> list3 = some.stream().filter(p->p.getstd()>=12).collect(Collectors.toList()); 
		 System.out.println(list3);
//		System.out.println(some);
	}
	
}
