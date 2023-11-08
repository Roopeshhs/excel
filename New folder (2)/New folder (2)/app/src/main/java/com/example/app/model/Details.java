package com.example.app.model;


import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Details")
public class Details {
	
	@Id
	
	private int id;
	@NotEmpty(message = " please give Account")
	private String Account;
	@NotEmpty(message = " please give Status")
	private String Status;
	@NotEmpty(message = " please give ExecutionArea")
	private String ExecutionArea;
	
	 
	 
	 
	public Details() {
		super();
	}



	public  Details(String Account, String Status, String ExecutionArea) {
		//super();
		this.Account = Account;
		this.Status = Status;
		this.ExecutionArea = ExecutionArea;
		
	}



	public int getId() {
		return id;
	}



	public String getAccount() {
		return Account;
	}



	public String getStatus() {
		return Status;
	}



	public String getExecutionArea() {
		return ExecutionArea;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setAccount(String account) {
		Account = account;
	}



	public void setStatus(String status) {
		Status = status;
	}



	public void setExecutionArea(String executionArea) {
		ExecutionArea = executionArea;
	}
	

}



