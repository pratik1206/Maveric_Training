package com.pract.java;
import java.util.Scanner;
public class Timepract {
	
	
	    public static void main(String[] args) {
	        // Create a Scanner object to read user input
	        Scanner scanner = new Scanner(System.in);

	        // Prompt the user to enter the current time
	        System.out.print("Enter the current time (HH:MM AM/PM): ");
	        String userTime = scanner.nextLine();

	        // Extract the hour from the user input
	        String hourString = userTime.split(":")[0];
	        int hour = Integer.parseInt(hourString);

	        // Extract the period (AM/PM) from the user input
	        String period = userTime.split(" ")[1];

	        // Convert hour to 24-hour format if it's PM
	        if (period.equalsIgnoreCase("PM")) {
	            hour += 12;
	        }

	        // Determine the period of the day using switch case
	        String timeOfDay;
	        switch (hour) {
	            case 5:
	            case 6:
	            case 7:
	            case 8:
	            case 9:
	            case 10:
	            case 11:
	                timeOfDay = "morning";
	                break;
	            case 12:
	            case 13:
	            case 14:
	            case 15:
	            case 16:
	            case 17:
	                timeOfDay = "afternoon";
	                break;
	            default:
	                timeOfDay = "evening";
	        }

	        // Print the period of the day
	        System.out.println("It's " + timeOfDay);

	        // Close the Scanner object
	        scanner.close();
	    }
	}



