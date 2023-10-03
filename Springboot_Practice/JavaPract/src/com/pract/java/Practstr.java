package com.pract.java;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Practstr {
public static void main(String[] args) {
	

	List<Integer> simple = new ArrayList<Integer>();
	simple.add(1);
	simple.add(2);
	simple.add(3);
	simple.add(4);
	simple.add(5);
	simple.add(6);
	simple.add(7);
	simple.add(8);
	simple.add(9);
	simple.add(10);
	
	List<Integer> even = simple.stream().filter(n->n%2==0).map(n->n).collect(Collectors.toList());
	System.out.println(even);
	
	int sum = simple.stream().filter(n -> n % 2 == 0).reduce(0, (a,b)->a+b);
	System.out.println(sum);
	
	double avg = even.stream().mapToInt(Integer::intValue)
            .average()
            .orElse(0.0);
	System.out.println(avg);
	
}
	
}
