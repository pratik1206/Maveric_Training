package com.pract.java;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

public class Practlist {
	public static void main(String[] args) {
		
	
List<String> name = Arrays.asList("Pratik","Ram","Ramesh","Rajsh","nilesh");

List<String> list2 = name.stream().filter(p->p.startsWith("R")).collect(Collectors.toList());
System.out.println(list2);
	
	List<String> list3 = list2.stream().map(p->p.toUpperCase()).collect(Collectors.toList());
	System.out.println(list3);
	
	List<String> list4 = name.stream().filter(p->p.startsWith("R")).map(p->p.toUpperCase()).sorted().collect(Collectors.toList());
	System.out.println(list4);
	
	
	}   
}
