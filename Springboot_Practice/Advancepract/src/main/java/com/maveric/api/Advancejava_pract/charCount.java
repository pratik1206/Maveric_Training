package com.maveric.api.Advancejava_pract;


	import java.util.HashMap;
	import java.util.Map; 

	 public class charCount { 
		public static Map<Character, Integer> Characterscount(String input) {
			Map<Character, Integer> charCount = new HashMap<>();

			for (char ch : input.toCharArray()) {
				charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
			}

			return charCount;
		}

		public static void main(String[] args) {
			String input = "abacd";
			Map<Character, Integer> result = Characterscount(input);
			System.out.println(result);
		}
	}

