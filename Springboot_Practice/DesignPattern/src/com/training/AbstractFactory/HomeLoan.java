package com.training.AbstractFactory;

class HomeLoan extends Loan{  
 	     public void getInterestRate(double r){  
 	         rate=r;  
 	    }  
 	}//End of the HomeLoan class.  
 	class BussinessLoan extends Loan{  
 	    public void getInterestRate(double r){  
 	          rate=r;  
 	     }  
 	  
 	}//End of the BusssinessLoan class.  
 	class EducationLoan extends Loan{  
 	     public void getInterestRate(double r){  
 	       rate=r;  
 	 }  
	}
