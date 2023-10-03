package com.pract.stream;


	import java.util.ArrayList;
	import java.util.HashSet;
	import java.util.List;
	import java.util.Set;
	import java.util.regex.Pattern;

	public class regstrPract {
	    public static void main(String[] args) {
	        List<String> usernames = new ArrayList<>();
	        usernames.add("Rajesh");
	        usernames.add("Amit#123");
	        usernames.add("Radha*456");
	        usernames.add("Priya123!");
	        usernames.add("Anuj@789");
	        usernames.add("Sneha");
	        usernames.add("Rohan*!98");
	        usernames.add("Ravi456");
	        usernames.add("Priya123!");

	        // Set to track encountered userusernames
	        Set<String> encounteredUserusernames = new HashSet<>();

	        // Regular expression pattern
	        String pattern = "(?=.*\\d)(?![\\d!#*])(?!\\d)[A-Za-z\\d!#*]{8,}";

	        // Check each username from the list
	        for (String username : usernames) {
	            // Check conditions using regex pattern
	            boolean isValid = username.matches(pattern) && !encounteredUserusernames.contains(username);

	            // Track encountered userusernames
	            encounteredUserusernames.add(username);

	            // Print the result
	            if (isValid) {
	                System.out.println(username + " is valid.");
	            } else {
	                System.out.println(username + " is invalid.");
	            }
	        }
	    }
	}


