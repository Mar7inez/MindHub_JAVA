package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.models.TransactionType;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository) {
		return (args) -> {

			//Add Client
			Client client1 = new Client("Melba", "Morel","melba@mindhub.com");
			clientRepository.save(client1);

			//Add Account
			Account account1 = new Account("VIN-0001",LocalDate.now(),5000,client1);
			Account account2 = new Account("VIN-0002", LocalDate.now(), 7500,client1);
			client1.addAccount(account1);
			client1.addAccount(account2);
			accountRepository.save(account1);
			accountRepository.save(account2);

			//add Transactions
			Transaction t1 = new Transaction(TransactionType.CREDIT, 500.0, "Bonus", LocalDateTime.now());
			Transaction t2 = new Transaction(TransactionType.DEBIT, 100.0, "extraction", LocalDateTime.now());
			account1.addTransaction(t1);
			account1.addTransaction(t2);


		};
	}
}
