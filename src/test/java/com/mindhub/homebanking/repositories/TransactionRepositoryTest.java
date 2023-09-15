package com.mindhub.homebanking.repositories;

import static org.junit.jupiter.api.Assertions.*;
import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.models.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TransactionRepositoryTest {

    @Autowired
    TransactionRepository transactionRepository;

    @Test
    public void existTransactions() {

        List<Transaction> transactions = transactionRepository.findAll();

        assertThat(transactions, is(not(empty())));

    }

    @Test
    public void positiveTransacction(){
        List<Transaction> transactions = transactionRepository.findAll();
        for (Transaction transaction : transactions) {
            assertThat(transaction.getAmount() , greaterThan(0d));
        }
    }

}