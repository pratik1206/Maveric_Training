package com.maveric.projectrest.Employee;



import jakarta.persistence.*;



@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long ID;
	 @Column(nullable = false)
	private String Firstname;
	 @Column(nullable = false)
	private String Lastname;
	 @Column(nullable = false)
	private String email;
	public Employee(Long iD, String firstname, String lastname, String email) {
		super();
		ID = iD;
		Firstname = firstname;
		Lastname = lastname;
		this.email = email;
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
