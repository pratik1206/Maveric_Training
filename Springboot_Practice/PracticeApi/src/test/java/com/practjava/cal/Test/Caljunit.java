//package com.practjava.cal.Test;
//
//import com.practjava.cal.Calculatorcl;
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.assertj.core.api.Assertions;
//import org.junit.Before;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//class Caljunit {
//
//
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
//	@Test
//	public void addTest() {
//		int expectedSum = 15;
//		int actualSum = cal.Add(x, y);
//		// Assert
//		assertEquals(expectedSum, actualSum);
//	}
//	@Test
//	public void subTest() {
//		int expectedSum = 5;
//		int actualSum = cal.Sub(x, y);
//		assertEquals(expectedSum, actualSum);
//	}
//
//}
