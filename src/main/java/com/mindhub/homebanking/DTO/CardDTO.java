package com.mindhub.homebanking.DTO;

import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.CardColor;
import com.mindhub.homebanking.models.CardType;
import com.mindhub.homebanking.models.Client;

import java.time.LocalDate;

public class CardDTO {
    private Long id;
    private LocalDate fromDate;
    private LocalDate thruDate;
    private int cvv;
    private String number;
    private String cardholder;
    private CardType type;
    private CardColor color;

    public CardDTO(Card card) {
        id = card.getId();
        fromDate = card.getFromDate();
        thruDate = card.getThruDate();
        cvv = card.getCvv();
        number = card.getNumber();
        cardholder = card.getCardholder();
        type = card.getType();
        color = card.getColor();
    }

    public Long getId() {
        return id;
    }
    public LocalDate getFromDate() {
        return fromDate;
    }
    public LocalDate getThruDate() {
        return thruDate;
    }
    public int getCvv() {
        return cvv;
    }
    public String getNumber() {
        return number;
    }
    public String getCardholder() {
        return cardholder;
    }
    public CardType getType() {
        return type;
    }
    public CardColor getColor() {
        return color;
    }

}
