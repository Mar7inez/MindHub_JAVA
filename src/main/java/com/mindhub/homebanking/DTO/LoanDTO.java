package com.mindhub.homebanking.DTO;

import com.mindhub.homebanking.models.Loan;

import java.util.List;

public class LoanDTO {

    private Long id;
    private String name;
    private double maxAmount;

    private List<Integer> payments;

    public LoanDTO() {
    }

    public LoanDTO(Loan loan) {
        id = loan.getId();
        name = loan.getName();
        maxAmount = loan.getMaxAmount();
        payments = loan.getPayments();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public List<Integer> getPayments() {
        return payments;
    }
}