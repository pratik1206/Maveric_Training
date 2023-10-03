package com.Test;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testregx {
        public static void main(String[] args) {
            String inputFile = "C:\\Users\\pratikw\\Desktop\\p\\input.txt.txt"; // Path to the input text file
            String outputFile = "C:\\Users\\pratikw\\Desktop\\p\\output.txt.txt"; // Path to the output text file

            try {
                String inputString = readTextFile(inputFile);
                String result = extractNumbersAndSpecialChars(inputString);
                writeTextFile(outputFile, result);
                System.out.println("Extraction successful. Results written to " + outputFile);
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        public static String extractNumbersAndSpecialChars(String input) {
            // Regular expression pattern to match numbers and special characters
            String regex = "[0-9@#]+";

            // Create a pattern object
            Pattern pattern = Pattern.compile(regex);

            // Create a matcher object
            Matcher matcher = pattern.matcher(input);

            // StringBuilder to store the extracted numbers and special characters
            StringBuilder sb = new StringBuilder();

            // Find and append matches to the StringBuilder
            while (matcher.find()) {
                sb.append(matcher.group()).append(" ");
            }

            return sb.toString().trim();
        }

        public static String readTextFile(String filePath) throws IOException {
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            reader.close();
            return sb.toString();
        }

        public static void writeTextFile(String filePath, String content) throws IOException {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content);
            writer.close();
        }
    }




