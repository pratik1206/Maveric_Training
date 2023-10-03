package com.maveric.api.Advancejava_pract.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
	import org.junit.jupiter.api.Test;
	import com.maveric.api.Advancejava_pract.Persistence;

	class persistanceTest { 


		@Autowired
		Persistence pers;
				
		int i = 999;
		@Test
		public void PersistenceTestCase() {
			int expectedResult = 4;
			int result = pers.persistence(i);

			assertEquals(expectedResult, result);

		}

	}


