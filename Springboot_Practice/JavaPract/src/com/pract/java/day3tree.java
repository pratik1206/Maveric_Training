package com.pract.java;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;

public class day3tree {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(45);
        list.add(23);
        list.add(21);
        
        System.out.println("Traverse LinkedList using Iterator (forward):");
        Iterator<Integer> forwardIterator = list.iterator();
        while (forwardIterator.hasNext()) {
            System.out.println(forwardIterator.next());
        }
        
        System.out.println("Traverse LinkedList using Iterator (backward):");
        ListIterator<Integer> backwardIterator = list.listIterator(list.size());
        while (backwardIterator.hasPrevious()) {
            System.out.println(backwardIterator.previous());
        }
    }
}
