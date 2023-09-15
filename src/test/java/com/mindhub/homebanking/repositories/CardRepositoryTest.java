package com.mindhub.homebanking.repositories;

import static org.junit.jupiter.api.Assertions.*;
import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.Client;
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
class CardRepositoryTest {

    @Autowired
    CardRepository  cardRepository;

    @Test
    public void existCard(){

        List<Card> accounts = cardRepository.findAll();

        assertThat(accounts,is(not(empty())));

    }

    @Test
    public void existTypeCard() {
        List<Card> cards = cardRepository.findAll();
        for (Card card :cards) {
            assertEquals(3, (String.valueOf(card.getCvv())).length());
        }
    }

}