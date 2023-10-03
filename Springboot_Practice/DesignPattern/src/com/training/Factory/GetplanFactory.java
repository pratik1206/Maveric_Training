package com.training.Factory;
//import com.training.Factory.Plan;
public class GetplanFactory {

	public Plan getPlan(String planType){  
		if(planType == null){  
			return null;  
		}  
		if(planType.equalsIgnoreCase("DOMESTICPLAN")) {  
			return new DomesticPlan();  
		}   
		else if(planType.equalsIgnoreCase("COMMERCIALPLAN")){  
			return new commercialPlan();  
		}   
		else if(planType.equalsIgnoreCase("institutationalPlan")) {  
			return new institutationalPlan();  
		}  
		return null;  
	}}
