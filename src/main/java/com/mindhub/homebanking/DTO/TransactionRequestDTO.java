package com.mindhub.homebanking.DTO;

public class TransactionRequestDTO {

    private String accountFromNumber;
    private String accountToNumber;
    private double amount;
    private String description;



    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getAccountFromNumber() {
        return accountFromNumber;
    }

    public String getAccountToNumber() {
        return accountToNumber;
    }
}