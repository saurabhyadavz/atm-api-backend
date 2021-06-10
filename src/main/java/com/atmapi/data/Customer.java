package com.atmapi.data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Customer {
	
	@Id
	private String accountNumber;
	private double balance;

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
	
	public Customer(String accountNumber, String firstName, String lastName) {
		super();
		this.accountNumber = accountNumber;
		this.balance=10000;
		
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
