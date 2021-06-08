package com.springrest.springrest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AtmService {
	
	private List<atm> lists= new ArrayList<atm>(Arrays.asList(new atm("21","saurabh","yadav")));
	
	public List<atm> getuserInfo(){
		return lists;
	}

	
   
	public String withdraw(String acc, atm atmx) {
		if(atmx.getBalance()<0)
			return "Failure";
		
		for(int i=0;i<lists.size();i++) {
			 atm a1=lists.get(i);
			 if(a1.getAccountNumber().equals(acc))
			 {
				 if(a1.getBalance()<atmx.getBalance()) {
					 
					 return "Failure";
				 }
				 
				 a1.setBalance(a1.getBalance()-atmx.getBalance());
			 }
		 }
		return "Success";
		
	}



	public String deposit(String acc, atm atmx) {
		
		for(int i=0;i<lists.size();i++) {
			 atm a1=lists.get(i);
			 if(a1.getAccountNumber().equals(acc))
			 {
				 
				 a1.setBalance(a1.getBalance()+atmx.getBalance());
				 return "Success";
			 }
		 }
		return "Failure";
	}



	public String openAccount(atm atmx) {
		if(atmx.getFirstName()!=null&&atmx.getLastName()!=null&&atmx.getBalance()>=0) {
			int b = (int)(Math.random()*(1000-100+1)+100);  
			atmx.setAccountNumber(Integer.toString(b));
			lists.add(atmx);
			return "Account created successfully";
			
		}
		return "Failure";
	}
	
	
	
	
}
		