package com.mindhub.homebanking.services;

import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.CardColor;
import com.mindhub.homebanking.models.CardType;
import com.mindhub.homebanking.models.Client;

public interface CardService {
    Card findByClientAndColorAndType(Client client, CardColor color, CardType type);
    Card findByNumber(String number);
    void saveCard(Card card);

}