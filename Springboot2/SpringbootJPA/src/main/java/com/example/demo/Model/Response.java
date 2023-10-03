package com.example.demo.Model;

public class Response {
	 private String message;
     private String error;
     private String status;
     private UserRecord userRecord;
     
     public Response() {
    	 
     }
     
	public Response(String message, String error, String status, UserRecord userRecord) {
		super();
		this.message = message;
		this.error = error;
		this.status = status;
		this.userRecord = userRecord;
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

	public UserRecord getUserRecord() {
		return userRecord;
	}

	public void setUserRecord(UserRecord userRecord) {
		this.userRecord = userRecord;
	}

	@Override
	public String toString() {
		return "Response [message=" + message + ", error=" + error + ", status=" + status + ", userRecord=" + userRecord
				+ "]";
	}
     
     
}
