package com.maveric.api.Advancejava_pract.Test;

	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;
	import java.util.*;
	import static org.junit.Assert.assertEquals;
	import com.maveric.api.Advancejava_pract.TagParcer;

	class TagParce_Test {
		@Test 
		public void testRetrieveValidContents() {
			List<String> lines = new ArrayList<>();
			lines.add("<h1>Nayeem loves football</h1>");
			lines.add("<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>");
			lines.add("<Amee>safat codes like a ninja</amee>");
			lines.add("<SA premium>Imtiaz has library</SA premium>");

			@SuppressWarnings("static-access")
			List<String> result = TagParcer.retrieveValidContents(lines);
			assertEquals("Nayeem loves football", result.get(0));
			assertEquals("Sanjay has no watch", result.get(1));
			assertEquals("So wait for a while", result.get(2));
			assertEquals("Imtiaz has library", result.get(3));
 
		}

	}


