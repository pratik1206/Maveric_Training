package com.training.Prototype;

public class EmployeeRecord implements Prototype {
    private int id;
    private String name;
    private String Designation;
    private double salary;
    private String Address;
    
    
	public EmployeeRecord(int id, String name, String designation, double salary, String address) {
		super();
		this.id = id;
		this.name = name;
		Designation = designation;
		this.salary = salary;
		Address = address;
		
	 
   
}
public void showRecord() {
	 System.out.println(id+"\t"+name+"\t"+Designation+"\t"+salary+"\t"+Address);
	}
@Override  
	    public Prototype getClone() {  
	      
	        return new EmployeeRecord(id,name,Designation,salary,Address);  
	    }
	 
}
