package com.maveric.training.Model;

public class Response {
     private String message;
     private String error;
     private String status;
     private Student student;
     
     public Response() {
    	 
     }
	public Response(String message, String error, String status, Student student) {
		super();
		this.message = message;
		this.error = error;
		this.status = status;
		this.student = student;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Response [message=" + message + ", error=" + error + ", status=" + status + ", student=" + student
				+ "]";
	}
     
     
}
