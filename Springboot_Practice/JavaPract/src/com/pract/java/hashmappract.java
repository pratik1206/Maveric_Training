package com.pract.java;

import java.util.HashMap;
public class hashmappract {
	
	    public static void main(String[] args) {
	        // Create the HashMap
	        HashMap<Integer, String> hashmap = new HashMap<>();
	        
	        // Add the key-value pair
	        hashmap.put(101, "My name is Pratik and Pratik works for Maveric ");
	        
	        // Get the original value from the HashMap
	        String value = hashmap.get(101);
	        
	        // Find the index of the first occurrence of "Pratik"
	        int firstIndex = value.indexOf("Pratik");
	        
	        // Find the index of the second occurrence of "Pratik"
	        int secondIndex = value.indexOf("Pratik", firstIndex + 1);
	        
	        // Replace the second occurrence of "Pratik" with "I"
	        String replacedValue = value.substring(0, secondIndex) + "I" + value.substring(secondIndex + 6);
	        
	        // Update the value in the HashMap
	        hashmap.put(101, replacedValue);
	        
	        // Print the updated HashMap
	        System.out.println(hashmap);
	        // Count the occurrences of "Pratik"
	        int occurrenceCount = value.split("Pratik", -1).length - 1;
	        
	        // Print the occurrence count
	        System.out.println("Number of occurrences of 'Pratik': " + occurrenceCount);
	    }
	}


