package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository) {
		return (args) -> {

			//Clients

			Client client1 = new Client("Melba", "Morel","melba@mindhub.com");
			clientRepository.save(client1);

			Client client2 = new Client("Julian", "Alvarez","araña@mindhub.com");
			clientRepository.save(client2);
			LocalDate today = LocalDate.now();

			Client client3 = new Client("Leo", "Messi","goat@mindhub.com");
			clientRepository.save(client3);


			//Accounts


			Account account1 = new Account("VIN-0001",LocalDate.now(),5000,client1);
			client1.addAccount(account1);
			accountRepository.save(account1);




			Account account2 = new Account("VIN-0002", LocalDate.now(), 7500,client1);
			accountRepository.save(account2);

			Account account3 = new Account("TEST",LocalDate.now(),200000,client2);
			accountRepository.save(account3);

			Account account4 = new Account("TEST2",LocalDate.now(),100000,client3);
			accountRepository.save(account4);




		};
	}
}
