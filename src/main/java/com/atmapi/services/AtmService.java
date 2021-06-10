package com.atmapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atmapi.dao.AtmRepository;
import com.atmapi.data.Customer;

@Service
public class AtmService {
	
	@Autowired
	private AtmRepository atmRepo;
	
	
	
	
   
	public String withdraw(Customer atmx) {
		
		List<Customer> details=new ArrayList<>();
				
		atmRepo.findAll()
		.forEach(details::add);
				
		if(atmx.getBalance()<=0)
			return "Failure";
		
		for(int i=0;i<details.size();i++) {
			 Customer a1=details.get(i);
			 if(a1.getAccountNumber().equals(atmx.getAccountNumber()))
			 {
				 if(a1.getBalance()<atmx.getBalance()) {
					 
					 return "Failure";
				 }
				 a1.setBalance(a1.getBalance()-atmx.getBalance());
				 atmRepo.save(a1);
				
			 }
		 }
		return "Success";
		
	}



	public String deposit(Customer atmx) {
		if(atmx.getBalance()<=0)
			return "Failure";
		List<Customer> details=new ArrayList<>();
		
		atmRepo.findAll()
		.forEach(details::add);
		
		
		for(int i=0;i<details.size();i++) {
			 Customer a1=details.get(i);
			 if(a1.getAccountNumber().equals(atmx.getAccountNumber()))
			 {
				 a1.setBalance(atmx.getBalance()+a1.getBalance());
				 atmRepo.save(a1);
				return "Success";
			 }
		 }
		return "Failure";
		
	}

	public Optional<Customer> checkBalance(String x) {
		
		return atmRepo.findById(x);		
	}
	


	public Optional<Customer> details(String accountNumber) {
		return atmRepo.findById(accountNumber);
		
	}


	public String addData(Customer c1) {
		atmRepo.save(c1);
		return "Success";
	}


	
	
	
	
}
		