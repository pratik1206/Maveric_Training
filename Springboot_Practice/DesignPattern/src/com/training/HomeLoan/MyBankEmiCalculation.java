package com.training.HomeLoan;

import java.io.IOException;
import java.util.Scanner;



public class MyBankEmiCalculation {
public static void main(String args[])throws IOException{ 
		
	   GetLonType LoanType = new GetLonType();  

		System.out.print("Enter the Loan Type: ");  
		Scanner br=new Scanner(System.in);  

		String planName=br.nextLine();  
		System.out.print("Enter the number of years ");  
		int years=Integer.parseInt(br.nextLine());  

		System.out.print("Enter the Amount ");  
		int amount=Integer.parseInt(br.nextLine());  

		interestRate p = LoanType.getLoan(planName); 
		//call getRate() method and calculateBill()method of DomesticPaln.  

		System.out.print("No of years "+years+" of  "+amount+" amount: ");  
		p.getRate();  
		p.calculateBill(amount,years);  
	}  
}
