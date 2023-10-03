package com.maveric.api.Advancejava_pract.Test;

	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;
	import com.maveric.api.Advancejava_pract.charCount;
	import java.util.HashMap;
	import java.util.Map;
	import static org.junit.Assert.assertEquals;

	public class charCount_Test {

		@Test
		public void testCountCharactersWithNonEmptyString() {
			String input = "abacd";
			Map<Character, Integer> expected = new HashMap<>();
			expected.put('a', 2);
			expected.put('b', 1);
			expected.put('c', 1);
			expected.put('d', 1);
			assertEquals(expected, charCount.Characterscount(input));
		}
	}
 
 

