package com.mindhub.homebanking.DTO;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountDTO {
    private long id;
    private String number;
    private double balance;
    private LocalDate date;
    private Client client;
    private Set<TransactionDTO> transaction;

    public AccountDTO(Account account) {
        this.id = account.getIdAccount();
        this.number = account.getNumber();
        this.balance = account.getBalance();
        this.date = account.getCreationDate();
        this.transaction = account.getTransaction()
                .stream()
                .map(transaction -> new TransactionDTO(transaction))
                .collect(Collectors.toSet());
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public LocalDate getCreationDate() {
        return date;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.date = creationDate;
    }
    public Set<TransactionDTO> getTransaction() {
        return transaction;
    }
}