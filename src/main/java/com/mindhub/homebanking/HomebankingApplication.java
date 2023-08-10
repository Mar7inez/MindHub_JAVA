package com.mindhub.homebanking;

import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository,
									  AccountRepository accountRepository,
									  TransactionRepository transactionRepository,
									  LoanRepository loanRepository,
									  ClientLoanRepository clientLoanRepository) {
		return (args) -> {


			//Add Loans and Save Loans
			Loan loan1 = new Loan("Mortgage", 500000.0, List.of(12,24,36,48,60));
			Loan loan2 = new Loan("Personal", 100000.0, List.of(6,12,24));
			Loan loan3 = new Loan("Automotive", 300000.0, List.of(6,12,24,36));

			loanRepository.save(loan1);
			loanRepository.save(loan2);
			loanRepository.save(loan3);


			//Add Client
			Client client1 = new Client("Melba", "Morel", "melba@mindhub.com");

			//Add account
			Account account1 = new Account("VIN-0001", LocalDate.now(), 5000.0);
			Account account2 = new Account("VIN-0002", LocalDate.now().plusDays(700), 7500.0);

			//Add Loan to Client
			ClientLoan clientLoan1 = new ClientLoan(400000.0, 60, client1, loan1);
			client1.addClientLoan(clientLoan1);

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

			//Add Loan to Client
	//		loan1.addClientLoan(clientLoan1);
	//		loan2.addClientLoan(clientLoan1);
			loan3.addClientLoan(clientLoan1);

			//Save Client
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

			//Save Loan to Client
			clientLoanRepository.save(clientLoan1);

		};
	}
}
