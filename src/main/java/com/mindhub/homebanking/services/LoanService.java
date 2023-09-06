package com.mindhub.homebanking.services;

import com.mindhub.homebanking.DTO.LoanDTO;
import com.mindhub.homebanking.models.Loan;

import java.util.List;

public interface LoanService {
    List<LoanDTO> getLoans();
    Loan findByName(String name);
    Loan saveLoan(Loan loan);

    Loan findById(Long id);
}