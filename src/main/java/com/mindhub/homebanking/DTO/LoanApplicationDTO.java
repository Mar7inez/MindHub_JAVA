package com.mindhub.homebanking.DTO;

public class LoanApplicationDTO {

    private Long id;
    private double amount;
    private Integer payments;
    private String toAccountNumber;


    public LoanApplicationDTO() {
    }


    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
    public Integer getPayments() {
        return payments;
    }
    public String getToAccountNumber() {
        return toAccountNumber;
    }


}