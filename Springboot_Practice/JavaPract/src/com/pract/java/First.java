package com.pract.java;

public class First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println("this is a java course");
      // series
     
     int FinalTerm = 0 , FirstTerm = 1, Secondterm = 0;
     int n = 20;
     
        System.out.println("Enter the value you want");
        
        for(int i=0;i<=n;i++) {
        	System.out.print(FirstTerm+" ,");
             FinalTerm = FirstTerm + Secondterm;
             Secondterm = FirstTerm;
             FirstTerm = FinalTerm;
                          
        
        }
	}

}
