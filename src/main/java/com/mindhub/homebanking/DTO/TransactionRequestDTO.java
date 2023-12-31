package com.mindhub.homebanking.DTO;

public class TransactionRequestDTO {
    private double amount;
    private String description;
    private String originAccount;
    private String destinationAccount;

    public TransactionRequestDTO() {
    }

    public TransactionRequestDTO(double amount, String description, String originAccount, String destinationAccount) {
        this.amount = amount;
        this.description = description;
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getOriginAccount() {
        return originAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }
}