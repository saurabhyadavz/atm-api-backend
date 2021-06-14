package com.atmapi.services;

import com.atmapi.model.Customer;

import java.util.Optional;

public interface AtmService {
    String withdraw(Customer c);
    String deposit(Customer c);
    Optional<Customer> checkBalance(String s);
    Optional<Customer> details(String s);
    String addData(Customer c);
}
