//package com.practjava.cal.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.Assert;
//import org.junit.internal.runners.statements.ExpectException;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//
//import com.practjava.cal.Calculatorcl;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//class Calculatetest2 {
//	@Autowired
//	static Calculatorcl cal ;
//
//	int x =10;
//	int y = 5;	
//
//	@BeforeAll
//	public static void setUp() {
//		cal = new Calculatorcl();
//	}
//
//
//	@Test
//	public void MultTest() {
//		int expectedSum = 50;
//		int actualSum = cal.Mult(x, y);
//		assertEquals(expectedSum, actualSum);
//	}
//
//	@Test
//	public void DivTest() {
//		int expectedSum = 2;
//		int actualSum = cal.Div(x, y);
//		assertEquals(expectedSum, actualSum);
//	}
//
//
//
//	//	 @Test(expectedExceptions = ArithmeticException.class)
//	@Test 
//	public void testDiv() {
//		Assertions.assertThrows(ArithmeticException.class, () -> 
//		cal.Div(10, 0));
//
//
//	}
//
//}
