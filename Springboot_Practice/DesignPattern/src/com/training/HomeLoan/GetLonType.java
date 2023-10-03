package com.training.HomeLoan;



public class GetLonType {
	public interestRate getLoan(String LoanType){  
		if(LoanType == null){  
			return null;  
		}  
		if(LoanType.equalsIgnoreCase("HomeLOAN")) {  
			return new HomeLoan();  
		}   
		else if(LoanType.equalsIgnoreCase("Carloan")){  
			return new Carloan();  
		}   
		else if(LoanType.equalsIgnoreCase("PersonalLoan")) {  
			return new PersonalLoan();  
		}  
		else if(LoanType.equalsIgnoreCase("BusinessLoan")) {  
			return new BusinessLoan();  
		} 
		return null;  
	}
}
