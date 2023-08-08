package com.mindhub.homebanking.models;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

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

        public Account(String number, LocalDate creationDate, double balance, Client client) {
            this.number = number;
            this.creationDate = creationDate;
            this.balance = balance;
            this.client = client;
        }

        public Account() {
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
}
