package com.practjava.cal;


public class Calculatorcl{


	public int Add(int x ,int y) {
		int sum  = x + y;
		System.out.println("Addition of the value is "+sum);
		return sum;
	}

	public int Sub(int x ,int y) {
		int Subt  = x - y;
		System.out.println("Subtraction of the value is "+Subt);
		return Subt;
	}

	public int Mult(int x ,int y) {
		int Multi  = x * y;
		System.out.println("Addition of the value is "+Multi);
		return Multi;
	}

	//	public int Div(int x ,int y) {
	//		int Divi  = x / y;
	//		if( y==0) {
	//			throw new ArithmeticException();
	//		}
	//		else {
	//			System.out.println("Division of the value is "+Divi);
	//			return Divi;
	//		}
	//		}


	public int Div(int x, int y) { 
		try { int Divi = x / y;
	System.out.println("Division of the value is " + Divi); return Divi; 
	} catch (ArithmeticException e) { System.out.println("An error occurred: " +
			e); throw new ArithmeticException() ; } }


	public static void main(String[] args) {

		Calculatorcl clr = new Calculatorcl();
		clr.Add(5,5);
		clr.Sub(10,5);
		clr.Mult(5, 5);
		clr.Div(10, 0);
	}
}

