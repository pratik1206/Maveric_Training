package com.training.Factory;
import java.io.IOException;
import java.util.*;

public class GenerateBill {
	public static void main(String args[])throws IOException{ 
		
		GetplanFactory planFactory = new GetplanFactory();  

		System.out.print("Enter the name of plan for which the bill will be generated: ");  
		Scanner br=new Scanner(System.in);  

		String planName=br.nextLine();  
		System.out.print("Enter the number of units for bill will be calculated: ");  
		int units=Integer.parseInt(br.nextLine());  

		Plan p = planFactory.getPlan(planName);  
		//call getRate() method and calculateBill()method of DomesticPaln.  

		System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");  
		p.getRate();  
		p.calculateBill(units);  
	}  
}

