package com.maveric.training.org;

public class Student {
   private Integer Sid;
   private String Sname;
   private Integer Age;
   
     Student(){
    	 System.out.println("Default constructor is called");
     }
public Student(Integer sid, String sname, Integer age) {
	 System.out.println("Parameterised constructor is called");
	
	Sid = sid;
	Sname = sname;
	Age = age;
}


public Integer getSid() {
	return Sid;
}


public void setSid(Integer sid) {
	Sid = sid;
}


public String getSname() {
	return Sname;
}


public void setSname(String sname) {
	Sname = sname;
}


public Integer getAge() {
	return Age;
}


public void setAge(Integer age) {
	Age = age;
}


@Override
public String toString() {
	return "Student [Sid=" + Sid + ", Sname=" + Sname + ", Age=" + Age + "]";
}

}
