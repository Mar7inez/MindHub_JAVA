package com.mindhub.homebanking.DTO;


import com.mindhub.homebanking.models.Client;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class ClientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<ClientLoanDTO> loans;
    private Set<AccountDTO> accounts;
    private Set<CardDTO> cards;

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.loans = client.getClientLoans().stream().map(ClientLoanDTO::new).collect(toSet());
        this.accounts = client.getAccounts().stream().map(AccountDTO::new).collect(toSet());
        this.cards = client.getCards().stream().map(CardDTO::new).collect(toSet());
    }
    public long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {return password;}
    public Set<ClientLoanDTO> getLoans(){ return loans; }
    public Set<AccountDTO> getAccounts() {return accounts;}
    public Set<CardDTO> getCards(){ return  cards;}


}