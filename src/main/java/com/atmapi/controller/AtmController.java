package com.atmapi.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atmapi.model.Customer;
import com.atmapi.services.AtmServiceImp;





@RestController
public class AtmController {
	
	 @Autowired
	 private AtmServiceImp atmServiceImp;
	
	

	@RequestMapping(method=RequestMethod.PUT, value="/withdraw")
	@CrossOrigin(origins="http://localhost:3000")
	public String withdraw(@RequestBody Customer atmx) {
		System.out.println("Withdraw");
		return atmServiceImp.withdraw(atmx);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/deposit")
	@CrossOrigin(origins="http://localhost:3000")
	public String deposit(@RequestBody Customer c1) {
		
		return atmServiceImp.deposit(c1);
	}
	@RequestMapping(method=RequestMethod.GET, value="/checkBalance")
	@CrossOrigin(origins="http://localhost:3000")
	public Optional<Customer> checkBalance(@RequestParam(value = "accountNumber", defaultValue = "0") String accountNumber) {
		
		return atmServiceImp.checkBalance(accountNumber);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/details")
	@CrossOrigin(origins="http://localhost:3000")
	public Optional<Customer> details(@RequestParam(value = "accountNumber", defaultValue = "0") String accountNumber) {
		
		return atmServiceImp.details(accountNumber);
	}

	//For Testing
	@RequestMapping(method=RequestMethod.POST, value="/addData")
	public String addData(@RequestBody Customer c1) {

		return atmServiceImp.addData(c1);
	}
	

}