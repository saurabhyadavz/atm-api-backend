package com.atmapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.Instant;
import javax.persistence.GeneratedValue;

@Entity
public class TransactionDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String accountNumber;
    private double totalBalance;
    private Timestamp time;
    private String debit;
    private String credit;
    private double amount;

    private String transDetails;

    public TransactionDetails(String accountNumber, double totalBalance,double amount, String debit, String credit, String transDetails) {
        this.accountNumber = accountNumber;
        this.totalBalance = totalBalance;
        this.time = Timestamp.from( Instant.now());
        this.debit = debit;
        this.credit = credit;
        this.transDetails = transDetails;
        this.amount=amount;
    }

    public TransactionDetails() {
    }
   public String getAccountNumber(){
        return this.accountNumber;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getDebit() {
        return debit;
    }

    public String getCredit() {
        return credit;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransDetails() {
        return transDetails;
    }
}
