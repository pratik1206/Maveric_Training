package com.pract.java;

public class Practoccurance {
	
	
	    public static void main(String[] args) {
	        String s = "my name is Pratik and Pratik works for maveric";
	        String wordToFind = "Pratik";
	        int count = countOccurrences(s, wordToFind);
	        System.out.println("Number of occurrences of '" + wordToFind + "': " + count);
	    }

	    public static int countOccurrences(String text, String word) {
	        int count = 0;
	        int index = text.indexOf(word);
	        while (index != -1) {
	            count++;
	            index = text.indexOf(word, index + word.length());
	        }
	        return count;
	    }
	}

