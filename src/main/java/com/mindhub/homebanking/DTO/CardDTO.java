package com.mindhub.homebanking.DTO;

import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.CardColor;
import com.mindhub.homebanking.models.CardType;

import java.time.LocalDate;

public class CardDTO {
    private Long id;
    private CardType type;
    private CardColor color;
    private String holder;
    private String number;
    private String cvv;
    private LocalDate fromDate;
    private LocalDate thruDate;
    public CardDTO(Card card){
        id = card.getId();
        type = card.getCardType();
        color = card.getCardColor();
        holder = card.getCardHolder();
        number = card.getNumber();
        cvv = card.getCvv();
        fromDate = card.getFromDate();
        thruDate = card.getThruDate();
    }
    public Long getId() {
        return id;
    }
    public CardType getType() {
        return type;
    }
    public CardColor getColor() {
        return color;
    }
    public String getHolder() {
        return holder;
    }
    public String getNumber() {
        return number;
    }
    public String getCvv() {
        return cvv;
    }
    public LocalDate getFromDate() {
        return fromDate;
    }
    public LocalDate getThruDate() {
        return thruDate;
    }
}
