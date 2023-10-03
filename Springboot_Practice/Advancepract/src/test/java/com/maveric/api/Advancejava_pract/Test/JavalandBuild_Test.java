package com.maveric.api.Advancejava_pract.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

	import org.junit.jupiter.api.Test;

	import com.maveric.api.Advancejava_pract.Javalandbuild;

	class JavalandBuild_Test {
		
		
		
		@Autowired
		Javalandbuild javal;
		int N=6;
		int K=2;
		int[] heights= {3, 1, 5, 1, 4, 3};

		@Test
		public void BracketSequenceCheckerTestCase() {
			int expectedResult = 3;
			@SuppressWarnings("static-access")
			int result = javal.minimumJumps(N,K,heights);

			assertEquals(expectedResult, result);

		}
	}

 

