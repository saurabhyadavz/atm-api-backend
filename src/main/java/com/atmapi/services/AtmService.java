package com.atmapi.services;
import java.util.List;
import com.atmapi.model.Customer;
import com.atmapi.model.TransactionDetails;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface AtmService {
    public ResponseEntity<Object> withdraw(Customer c,String details);
    ResponseEntity<Object> deposit(Customer c,String details);
    Optional<Customer> checkBalance(String s);
    Optional<Customer> loginUser(String accountNumber);
    ResponseEntity<Object> transferMoney(String accountNumber, Customer c1);
    List<TransactionDetails> getTransactionDetails(String accountNumber);
    void addData(Customer c);


}
