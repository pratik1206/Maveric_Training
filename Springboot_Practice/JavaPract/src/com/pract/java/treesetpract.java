package com.pract.java;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.*;
public class treesetpract {

	    public static void main(String[] args) {
	        TreeSet<Integer> treeSet = new TreeSet<>();
	        
	        treeSet.add(2);
	        treeSet.add(4);
	        treeSet.add(5);
	        treeSet.add(6);
	        treeSet.add(7);
	        treeSet.add(45);
	        treeSet.add(23);
	        treeSet.add(21);
	        
	        System.out.println("Numbers less than 7 in the TreeSet:");
	        for (Integer num : treeSet) {
	            if (num < 7) {
	                System.out.println(num);
	            }
	        }
	        System.out.println("Traverse TreeSet using Iterator (forward):");
	        Iterator<Integer> forwardIterator = treeSet.iterator();
	        while (forwardIterator.hasNext()) {
	            System.out.println(forwardIterator.next());
	        }
	        
	        System.out.println("Traverse TreeSet using Iterator (backward):");
	        Iterator<Integer> backwardIterator = treeSet.descendingIterator();
	        while (backwardIterator.hasNext()) {
	            System.out.println(backwardIterator.next());
	        }
	    }
	}

