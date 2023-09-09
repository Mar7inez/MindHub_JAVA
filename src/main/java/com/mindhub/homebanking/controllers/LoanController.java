package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.DTO.LoanApplicationDTO;
import com.mindhub.homebanking.DTO.LoanDTO;
import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.repositories.LoanRepository;
import com.mindhub.homebanking.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LoanController {
    @Autowired
    private LoanService loanService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ClientLoanService clientLoanService;


    @GetMapping("/loans")
    public List<LoanDTO> getLoans(){
        return loanService.getLoans();
    }

    @Transactional
    @PostMapping(value = "/loans")
    public ResponseEntity<Object> createLoan(Authentication authentication, @RequestBody LoanApplicationDTO loanApplicationDTO) {

        Loan loan = loanService.findById(loanApplicationDTO.getId());
        double amount = loanApplicationDTO.getAmount();
        String destinationAccount = loanApplicationDTO.getToAccountNumber();
        Integer payments = loanApplicationDTO.getPayments();
        Account accountDestination = accountService.findByNumber(destinationAccount);

        Loan requestedLoan = loanService.findByName(loan.getName());

        Client client = clientService.findByEmail(authentication.getName());
       if(amount==0 || amount==' '){
            return new ResponseEntity("Please enter loan amount", HttpStatus.FORBIDDEN);
        }
        if(destinationAccount.isBlank() ){
            return new ResponseEntity("Please enter a destination account.", HttpStatus.FORBIDDEN);
        }
        if(requestedLoan.getMaxAmount()<amount){
            return new ResponseEntity("Amount exceeded.", HttpStatus.FORBIDDEN);
        }
        if(!requestedLoan.getPayments().contains(payments)){
            return new ResponseEntity("Wrong payments.", HttpStatus.FORBIDDEN);
        }
        if(accountService.findByNumber(destinationAccount)==null){
            return new ResponseEntity("Destination account doesn't exists.", HttpStatus.FORBIDDEN);
        }
        if(accountService.findByClientAndNumber(client,destinationAccount)==null){
            return new ResponseEntity<>("This account does not belong to this client.", HttpStatus.FORBIDDEN);
        }
        else{
            ClientLoan clientloan = new ClientLoan(amount+amount*0.2, payments);
            client.addClientLoan(clientloan);
            requestedLoan.addClientLoan(clientloan);
            Transaction transactionLoan=new Transaction(TransactionType.CREDIT, LocalDateTime.now()," "+"Loan approved",amount);

            transactionService.saveTransaction(transactionLoan);
            clientLoanService.saveClientLoan(clientloan);

            accountDestination.addTransaction(transactionLoan);
            accountDestination.setBalance(accountDestination.getBalance()+amount);

            return new ResponseEntity<>("Loan request created",HttpStatus.CREATED);
        }
    }


}