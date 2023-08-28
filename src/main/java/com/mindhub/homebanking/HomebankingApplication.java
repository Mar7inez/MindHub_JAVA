package com.mindhub.homebanking;

import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class HomebankingApplication {

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository,
									  AccountRepository accountRepository,
									  TransactionRepository transactionRepository,
									  LoanRepository loanRepository,
									  ClientLoanRepository clientLoanRepository,
									  CardRepository cardRepository) {
		return (args) -> {

			//Create and save Loans
			Loan loanMortgage = new Loan("Mortgage", 500000.0, List.of(12,24,36,48,60));
			Loan loanPersonal = new Loan("Personal", 100000.0, List.of(6,12,24));
			Loan loanAutomotive = new Loan("Automotive", 300000.0, List.of(6,12,24,36));

			loanRepository.save(loanMortgage);
			loanRepository.save(loanPersonal);
			loanRepository.save(loanAutomotive);


			//Create -> Clients, Accounts
			Client client1 = new Client("Melba", "Morel", "melba@mindhub.com", passwordEncoder.encode("password"));
			Client client2 = new Client("Rodrigo", "Ribeiro", "test@mindhub.com", passwordEncoder.encode("1234"));

			Client admin = new Client("admin", "admin", "admin@admin.com",passwordEncoder.encode("admin"));


			Account account1 = new Account("VIN-0001", LocalDate.now(), 5000.0);
			Account account2 = new Account("VIN-0002", LocalDate.now().plusDays(1), 7500.0);
			Account account3 = new Account("VIN-0003", LocalDate.now(), 12345.0);
			Account account4 = new Account("VIN-0004", LocalDate.now().plusDays(1), 4321.0);

			ClientLoan clientLoan1 = new ClientLoan(400000.0, 60, client1, loanMortgage);
			ClientLoan clientLoan2 = new ClientLoan(50000.0, 12, client1, loanPersonal);
			ClientLoan clientLoan3 = new ClientLoan(100000.0, 24, client2, loanPersonal);
			ClientLoan clientLoan4 = new ClientLoan(200000.0, 36, client2, loanAutomotive);

			client1.addClientLoan(clientLoan1);
			client1.addClientLoan(clientLoan2);

			client2.addClientLoan(clientLoan3);
			client2.addClientLoan(clientLoan4);

			loanMortgage.addClientLoan(clientLoan1);
			loanPersonal.addClientLoan(clientLoan2);
			loanPersonal.addClientLoan(clientLoan3);
			loanAutomotive.addClientLoan(clientLoan4);

			//Add transactions
			Transaction trans1  = new Transaction(TransactionType.CREDIT, 3000.0, "deposit", LocalDateTime.now());
			Transaction trans2  = new Transaction(TransactionType.DEBIT, 500.0, "extraction", LocalDateTime.now());
			Transaction trans3  = new Transaction(TransactionType.CREDIT, 600.0, "deposit", LocalDateTime.now());
			Transaction trans4  = new Transaction(TransactionType.DEBIT, 500.0, "extraction", LocalDateTime.now());
			Transaction trans5  = new Transaction(TransactionType.CREDIT, 3000.0, "deposit", LocalDateTime.now());
			Transaction trans6  = new Transaction(TransactionType.DEBIT, 500.0, "extraction", LocalDateTime.now());
			Transaction trans7  = new Transaction(TransactionType.CREDIT, 3600.0, "deposit", LocalDateTime.now());
			Transaction trans8  = new Transaction(TransactionType.DEBIT, 1000.0, "extraction", LocalDateTime.now());
			Transaction trans9  = new Transaction(TransactionType.CREDIT, 1500.0, "deposit", LocalDateTime.now());
			Transaction trans10 = new Transaction(TransactionType.DEBIT, 900.0, "extraction", LocalDateTime.now());
			Transaction trans11 = new Transaction(TransactionType.CREDIT, 1000.0, "deposit", LocalDateTime.now());
			Transaction trans12 = new Transaction(TransactionType.DEBIT, 2600.0, "extraction", LocalDateTime.now());
			Transaction trans13 = new Transaction(TransactionType.CREDIT, 1000.0, "deposit", LocalDateTime.now());
			Transaction trans14 = new Transaction(TransactionType.DEBIT, 200.0, "extraction", LocalDateTime.now());
			Transaction trans15 = new Transaction(TransactionType.CREDIT, 5000.0, "deposit", LocalDateTime.now());
			Transaction trans16 = new Transaction(TransactionType.DEBIT, 2000.0, "extraction", LocalDateTime.now());
			Transaction trans17 = new Transaction(TransactionType.CREDIT, 2600.0, "deposit", LocalDateTime.now());
			Transaction trans18 = new Transaction(TransactionType.DEBIT, 1000.0, "extraction", LocalDateTime.now());
			Transaction trans19 = new Transaction(TransactionType.CREDIT, 800.0, "deposit", LocalDateTime.now());
			Transaction trans20 = new Transaction(TransactionType.DEBIT, 7600.0, "extraction", LocalDateTime.now());

			//Add transactions to Accounts
			account1.addTransaction(trans1);
			account1.addTransaction(trans2);
			account1.addTransaction(trans5);
			account1.addTransaction(trans6);
			account1.addTransaction(trans9);
			account1.addTransaction(trans10);
			account1.addTransaction(trans13);
			account1.addTransaction(trans14);
			account1.addTransaction(trans17);
			account1.addTransaction(trans18);

			account2.addTransaction(trans3);
			account2.addTransaction(trans4);
			account2.addTransaction(trans7);
			account2.addTransaction(trans8);
			account2.addTransaction(trans11);
			account2.addTransaction(trans12);
			account2.addTransaction(trans15);
			account2.addTransaction(trans16);
			account2.addTransaction(trans19);
			account2.addTransaction(trans20);

			//Add Account to Client
			client1.addAccount(account1);
			client1.addAccount(account2);

			//Save Client
			clientRepository.save(client1);
			clientRepository.save(client2);
			clientRepository.save(admin);

			//Cards
            //Credit
			Card card1=new Card(LocalDate.now(),LocalDate.now().plusYears(5),211,"2225-6724-56336-2889","Melba Morel",CardType.CREDIT,CardColor.TITANIUM);
			Card card3=new Card(LocalDate.now(),LocalDate.now().plusYears(5),113,"2255-5666-3634-1112","Cliente Cliente",CardType.CREDIT,CardColor.SILVER);
			//Debit
			Card card4=new Card(LocalDate.now(),LocalDate.now().plusYears(5),122,"3325-6745-7876-4445","Melba Morel",CardType.DEBIT,CardColor.GOLD);
            client1.addCard(card1);
         //   client1.addCard(card2);
            client1.addCard(card4);
			client2.addCard(card3);

			cardRepository.save(card1);
		//	cardRepository.save(card2);
			cardRepository.save(card3);
            cardRepository.save(card4);
			clientRepository.save(client1);




			//Save Accounts
			accountRepository.save(account1);
			accountRepository.save(account2);

			//Save Transaction
			transactionRepository.save(trans1);
			transactionRepository.save(trans2);
			transactionRepository.save(trans3);
			transactionRepository.save(trans4);
			transactionRepository.save(trans5);
			transactionRepository.save(trans6);
			transactionRepository.save(trans7);
			transactionRepository.save(trans8);
			transactionRepository.save(trans9);
			transactionRepository.save(trans10);
			transactionRepository.save(trans11);
			transactionRepository.save(trans12);
			transactionRepository.save(trans13);
			transactionRepository.save(trans14);
			transactionRepository.save(trans15);
			transactionRepository.save(trans16);
			transactionRepository.save(trans17);
			transactionRepository.save(trans18);
			transactionRepository.save(trans19);
			transactionRepository.save(trans20);


			client1.addAccount(account1);
			client1.addAccount(account2);
			client2.addAccount(account3);
			client2.addAccount(account4);

			clientRepository.save(client1);
			clientRepository.save(client2);

			accountRepository.save(account1);
			accountRepository.save(account2);
			accountRepository.save(account3);
			accountRepository.save(account4);




			clientLoanRepository.save(clientLoan1);
			clientLoanRepository.save(clientLoan2);
			clientLoanRepository.save(clientLoan3);
			clientLoanRepository.save(clientLoan4);




		};
	}
}
