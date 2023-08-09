package com.mindhub.homebanking.models;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @GenericGenerator(name = "native", strategy = "native")
        private long id;
        private String number;
        private LocalDate creationDate;
        private double balance;
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name="client_id")
        private Client client;
        @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
        private Set<Transaction> transactions = new HashSet<>();

        public Account() {
        }

    public Account(String number, LocalDate creationDate, double balance) {
        this.number = number;
        this.creationDate = creationDate;
        this.balance = balance;

    }

        public long getId() {
            return id;
        }

        public String getNumber() {
            return number;
        }

        public LocalDate getCreationDate() {
            return creationDate;
        }

        public double getBalance() {
            return balance;
        }

        @JsonIgnore
        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }

         public Set<Transaction> getTransactions(){ return transactions; }

        public void addTransaction(Transaction transaction){
        transaction.setAccount(this);
        transactions.add(transaction);
    }
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", creationDate=" + creationDate +
                ", balance=" + balance +
                ", client=" + client +
                ", transactions=" + transactions +
                '}';
    }
}
