package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.DTO.TransactionRequestDTO;
import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.models.TransactionType;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.repositories.TransactionRepository;
import com.mindhub.homebanking.services.AccountService;
import com.mindhub.homebanking.services.ClientService;
import com.mindhub.homebanking.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RequestMapping("/api")
@RestController
public class TransactionController {
    @Autowired
    AccountService accountService;
    @Autowired
    ClientService clientService;
    @Autowired
    TransactionService transactionService;

    @Transactional
    @RequestMapping(path = "/transactions",method = RequestMethod.POST)
    public ResponseEntity<Object> getCurrentClientTransaction(
            Authentication authentication,
            @RequestParam String fromAccountNumber,
            @RequestParam  String toAccountNumber,
            @RequestParam Double amount,
            @RequestParam String description){

        Client client=clientService.findByEmail(authentication.getName());
        Account accountOrigin=accountService.findByNumber(fromAccountNumber);
        Account accountDestination=accountService.findByNumber(toAccountNumber);

        if(description.isBlank()){
            return new ResponseEntity<>("Please enter a description.", HttpStatus.FORBIDDEN);
        }
        if(toAccountNumber.isBlank() || fromAccountNumber.isBlank()){
            return new ResponseEntity<>("Please enter a destination account.", HttpStatus.FORBIDDEN);
        }
        if(fromAccountNumber.isBlank()){
            return new ResponseEntity<>("Please enter a source account.", HttpStatus.FORBIDDEN);
        }
        if (fromAccountNumber.equals(toAccountNumber)){
            return new ResponseEntity<>("Please enter a different destination account.", HttpStatus.FORBIDDEN);
        }
        if(accountService.findByNumber(fromAccountNumber)==null){
            return new ResponseEntity<>("Source account does not exists.", HttpStatus.FORBIDDEN);
        }
        if(accountService.findByClientAndNumber(client,fromAccountNumber)==null){
            return new ResponseEntity<>("This account does not belong to this client.", HttpStatus.FORBIDDEN);
        }
        if(accountService.findByNumber(toAccountNumber)==null){
            return new ResponseEntity<>("Destination account does not exists.", HttpStatus.FORBIDDEN);
        }
        if(accountService.findByNumber(fromAccountNumber).getBalance()<amount){
            return new ResponseEntity<>("Insufficient funds.", HttpStatus.FORBIDDEN);
        }
        if(amount==0){
            return new ResponseEntity<>("Please enter an amount to transfer.", HttpStatus.FORBIDDEN);
        }

        else{
            Transaction transactionDebit=new Transaction(TransactionType.DEBIT, LocalDateTime.now(),description,-amount);
            Transaction transactionCredit=new Transaction(TransactionType.CREDIT, LocalDateTime.now(),description,amount);
            accountOrigin.addTransaction(transactionDebit);
            accountDestination.addTransaction(transactionCredit);
            transactionService.saveTransaction(transactionCredit);
            transactionService.saveTransaction(transactionDebit);
            accountOrigin.setBalance(accountOrigin.getBalance()-amount);
            accountDestination.setBalance(accountDestination.getBalance()+amount);
            accountService.saveAccount(accountOrigin);
            accountService.saveAccount(accountDestination);
            return new ResponseEntity<>("Transaction created",HttpStatus.CREATED);
        }
    }
}