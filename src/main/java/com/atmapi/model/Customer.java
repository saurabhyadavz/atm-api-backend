package com.atmapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Customer {
	
	@Id
	private String accountNumber;
	private double balance;
	private String name;
	private String aadhaarNo;
	private String panNo;

	public String getName() {
		return name;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public String getAccountNumber() {
		return accountNumber;
	} 
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
