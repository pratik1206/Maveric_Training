package com.pract.java;
interface Outerface{
	
	void outerMethod();
	
	interface NestedInterface{
		void printMessage();
	}
}
class Myclass implements Outerface,Outerface.NestedInterface{
	public void outerMethod() {
		System.out.println("Hello from the outer interface");
	}
	public void printMessage() {
		System.out.println("Hello from the nested interface");
	}
}
public class TestInterface {
	
	
	
public static void main(String[] args) {
	Outerface nestobj = new Myclass();
	nestobj.outerMethod();
	Outerface.NestedInterface nestobj1 = new Myclass();
	nestobj1.printMessage();
}

}
