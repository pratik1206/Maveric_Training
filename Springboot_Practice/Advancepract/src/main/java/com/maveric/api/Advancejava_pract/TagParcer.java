package com.maveric.api.Advancejava_pract;


	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	public class TagParcer {

		public static List<String> retrieveValidContents(List<String> lines) {

			List<String> validContents = new ArrayList<>();

			// Regex pattern to match start and end tags
			String patternString = "<([\\w\\s]+)>([^<]+)</\\1>";
			Pattern pattern = Pattern.compile(patternString); 
			// Iterate through each line of text

			for (String line : lines) {
				Matcher matcher = pattern.matcher(line);
				// Find all occurrences of valid tags
				while (matcher.find()) {
					String content = matcher.group(2);
					validContents.add(content);
				}
			}
			return validContents;
		}

		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the number of lines: ");
			int numLines = scanner.nextInt();
			scanner.nextLine(); // Consume newline character
			List<String> lines = new ArrayList<>();
			for (int i = 0; i < numLines; i++) {
				//System.out.print("Enter line " + (i + 1) + ": ");
				String line = scanner.nextLine();
				lines.add(line);
			}
			List<String> result = retrieveValidContents(lines);
			if (result.isEmpty()) {
				System.out.println("None");
			} else {
				for (String content : result) {
					System.out.println(content);
				}
			}
		}
	}


