package com.atmapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.atmapi.dao.AtmRepository;
import com.atmapi.model.Customer;

@Service
public class AtmServiceImp implements AtmService {
	
	@Autowired
	private AtmRepository atmRepo;

	@Override
	public ResponseEntity<Object> withdraw(Customer atmx) {
		
		List<Customer> details=new ArrayList<>();
				
		atmRepo.findAll()
		.forEach(details::add);
				
		if(atmx.getBalance()<=0)
			return new ResponseEntity<>(atmx, HttpStatus.METHOD_NOT_ALLOWED);

		for (Customer a1 : details) {
			if (a1.getAccountNumber().equals(atmx.getAccountNumber())) {
				if (a1.getBalance() < atmx.getBalance()) {

					return new ResponseEntity<>(atmx, HttpStatus.METHOD_NOT_ALLOWED);
				}
				a1.setBalance(a1.getBalance() - atmx.getBalance());
				atmRepo.save(a1);

			}
		}
		return new ResponseEntity<>(atmx, HttpStatus.OK);
		
	}


	@Override
	public ResponseEntity<Object> deposit(Customer atmx) {

		if(atmx.getBalance()<=0)
			return new ResponseEntity<>(atmx, HttpStatus.METHOD_NOT_ALLOWED);
		List<Customer> details=new ArrayList<>();
		
		atmRepo.findAll()
		.forEach(details::add);


		for (Customer a1 : details) {
			if (a1.getAccountNumber().equals(atmx.getAccountNumber())) {
				a1.setBalance(atmx.getBalance() + a1.getBalance());
				atmRepo.save(a1);
				return new ResponseEntity<>(a1, HttpStatus.OK);
			}
		}

		return new ResponseEntity<>(atmx, HttpStatus.METHOD_NOT_ALLOWED);
		
	}

	@Override
	public Optional<Customer> checkBalance(String x) {
		
		return atmRepo.findById(x);		
	}

	@Override
	public Optional<Customer> details(String accountNumber) {
		return atmRepo.findById(accountNumber);
		
	}

	@Override
	public void addData(Customer c1) {
		atmRepo.save(c1);


	}

	
}
		