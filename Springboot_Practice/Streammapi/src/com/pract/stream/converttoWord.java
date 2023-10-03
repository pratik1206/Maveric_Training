package com.pract.stream;

import java.util.Scanner;

public class converttoWord {
	private static final String[] units = { "", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine" };
	private static final String[] tens = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
			"eighty", "ninety" };
	private static final String[] teens = { "", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
			"seventeen", "eighteen", "nineteen" };

	public static String convertToWords(int number) {
		if (number == 0) {
			return "zero";
		}

		if (number < 0) {
			return "minus " + convertToWords(-number);
		}

		if (number < 10) {
			return units[number];
		}

		if (number < 20) {
			return teens[number - 10];
		}

		if (number < 100) {
			int tensDigit = number / 10;
			int unitsDigit = number % 10;

			return tens[tensDigit] + " " + units[unitsDigit];
		}

		if (number < 1000) {
			int hundredsDigit = number / 100;
			int remainingDigits = number % 100;

			return units[hundredsDigit] + " hundred " + convertToWords(remainingDigits);
		}

		// For numbers greater than or equal to 1000, you can extend the logic as needed

		return "Number out of range";
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int number = scanner.nextInt();

		String words = convertToWords(number);
		System.out.println("Output: " + words);
	}
}
