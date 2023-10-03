package com.pract.stream;

class Supervisor{
	private int id;
	private String name;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Supervisor(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Supervisor [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
}

public class Employee2 {
	private int eid;
	private String ename;
	private String Eemail;
	private String Dept;
	private Supervisor supervisor;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEemail() {
		return Eemail;
	}
	public void setEemail(String eemail) {
		Eemail = eemail;
	}
	public String getDept() {
		return Dept;
	}
	public void setDept(String dept) {
		Dept = dept;
	}
	public Supervisor getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}
	public Employee2(int eid, String ename, String eemail, String dept, Supervisor supervisor) {
		super();
		this.eid = eid;
		this.ename = ename;
		Eemail = eemail;
		Dept = dept;
		this.supervisor = supervisor;
	}
	@Override
	public String toString() {
		return "Employee2 [eid=" + eid + ", ename=" + ename + ", Eemail=" + Eemail + ", Dept=" + Dept + ", supervisor="
				+ supervisor + "]";
	}
	
	

}
