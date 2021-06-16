package com.atmapi.services;
import java.util.*;

import com.atmapi.dao.TransactionRepository;
import com.atmapi.model.TransactionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.atmapi.dao.AtmRepository;
import com.atmapi.model.Customer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@Service
public class AtmServiceImp implements AtmService {

//	private static final Logger logger = LoggerFactory.getLogger(AtmServiceImp.class);
	@Autowired
	private AtmRepository atmRepo;

	@Autowired
	TransactionRepository transRepo;

	@Override
	public ResponseEntity<Object> withdraw(Customer atmx,String details) {
		String id=atmx.getAccountNumber();
		double amount=atmx.getBalance();
		Customer c=atmRepo.findById(id).orElse(new Customer());
		double balance=c.getBalance();
		if(balance>0&&balance>=amount){
			atmRepo.deleteById(id);
			c.setBalance(balance-amount);
			atmRepo.save(c);
			TransactionDetails t=new TransactionDetails(c.getAccountNumber(),c.getBalance(),amount,"debit","",details);
			transRepo.save(t);
			return new ResponseEntity<>(atmx, HttpStatus.OK);
		}

		return new ResponseEntity<>(atmx, HttpStatus.METHOD_NOT_ALLOWED);
		
	}


	@Override
	public ResponseEntity<Object> deposit(Customer request,String details) {
		String id = request.getAccountNumber();
		double amount=request.getBalance();
		Customer c=atmRepo.findById(id).orElse(new Customer());
		double balance=c.getBalance();
		if(amount>0){
			atmRepo.deleteById(id);
			c.setBalance(balance+amount);
			atmRepo.save(c);
			TransactionDetails t=new TransactionDetails(c.getAccountNumber(),c.getBalance(),amount,"","credit",details);
			transRepo.save(t);
			return new ResponseEntity<>(request, HttpStatus.OK);
		}

		return new ResponseEntity<>(request, HttpStatus.METHOD_NOT_ALLOWED);

		
	}

	@Override
	public Optional<Customer> checkBalance(String x) {
		
		return atmRepo.findById(x);		
	}

	@Override
	public Optional<Customer> loginUser(String accountNumber){
		return atmRepo.findById(accountNumber);
	}

	@Override
	public void addData(Customer c1) {
		atmRepo.save(c1);


	}
	@Override
	public ResponseEntity<Object> transferMoney(String accountNumber, Customer c1) {
		var x=atmRepo.findById(c1.getAccountNumber());
		if(x.isPresent()){
			double amount =c1.getBalance();
			Customer c=new Customer();
			c.setAccountNumber(accountNumber);
			c.setBalance(amount);
			withdraw(c,"Transferred to "+c1.getAccountNumber());
			c.setAccountNumber(c1.getAccountNumber());
			deposit(c,"Transferred by "+accountNumber);
			return new ResponseEntity<>(c1, HttpStatus.OK);

		}
		return new ResponseEntity<>(c1, HttpStatus.METHOD_NOT_ALLOWED);
	}
	@Override
	public List<TransactionDetails> getTransactionDetails(String accountNumber) {

		List<TransactionDetails> allDetails=new ArrayList<>();
		List<TransactionDetails> records=new ArrayList<>();
		transRepo.findAll()
				.forEach(allDetails::add);
		for(TransactionDetails t:allDetails){
			if(t.getAccountNumber().equals(accountNumber))
				records.add(t);
		}
		Collections.reverse(records);
		return records;
		}

}
		