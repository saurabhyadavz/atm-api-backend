package com.atmapi.services;

import com.atmapi.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface AtmService {
    ResponseEntity<Object> withdraw(Customer c);
    ResponseEntity<Object> deposit(Customer c);
    Optional<Customer> checkBalance(String s);
    Optional<Customer> details(String s);
    void addData(Customer c);
}
