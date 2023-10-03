package com.maveric.api.Advancejava_pract.Test;

	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import static org.junit.Assert.assertEquals;
	import com.maveric.api.Advancejava_pract.BracketChecker;

	class BracketChecker_Test {

		
		@Autowired
		BracketChecker bracket;
		
		String i = "(a+[b*c]-{d/3})";
		String j = "(a + [b * c) - 17]";
  
		@Test
		public void BracketSequenceCheckerTestCase() {
			int expectedResult = 1;
			@SuppressWarnings("static-access")
			int result = bracket.checkBracketSequence(i);

			assertEquals(expectedResult, result);

		}
		
		@Test
		public void BracketSequenceCheckerTestCase1() {
			int expectedResult = 0;
			@SuppressWarnings("static-access")
			int result = bracket.checkBracketSequence(j);

			assertEquals(expectedResult, result);

		}



	}



