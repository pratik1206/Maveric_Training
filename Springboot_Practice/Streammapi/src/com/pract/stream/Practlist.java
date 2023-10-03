package com.pract.stream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

public class Practlist {
	
	public static void main(String[] args) {
		


	List<Integer> sample = new ArrayList<>();
	sample.add(1);
	sample.add(2);
	sample.add(4);
	sample.add(4);
	sample.add(5);
	sample.add(9);
	sample.add(7);
	sample.add(8);
	sample.add(9);
	sample.add(10);
	
	Map<Boolean,List<Integer>> list = sample.stream().collect(Collectors.partitioningBy(n->n%2==0));
	System.out.println(list);
	
	IntSummaryStatistics list2 = sample.stream().collect(Collectors.summarizingInt(Integer::intValue));
	System.out.println("Sum"+list2);
	System.out.println("Sum"+list2.getSum());
	System.out.println("Count"+list2.getCount());
	System.out.println("Average"+list2.getAverage());
	System.out.println("MAx"+list2.getMax());
	System.out.println("Min"+list2.getMin());
	
	int secondmax = sample.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
    System.out.println("Secondmax prog"+secondmax);
    int secondlow = sample.stream().distinct().sorted().skip(1).findFirst().get();
    System.out.println("secondlow prog"+secondlow);

	
	
	
	
	}
	
	
}
