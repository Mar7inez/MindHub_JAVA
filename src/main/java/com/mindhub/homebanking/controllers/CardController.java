package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.CardColor;
import com.mindhub.homebanking.models.CardType;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.CardRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class CardController {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CardRepository cardRepository;

    @RequestMapping(path = "/clients/current/cards", method = RequestMethod.POST)
    public ResponseEntity<Object> createCard(Authentication authentication,
                                             @RequestParam("cardType") CardType type,
                                             @RequestParam("cardColor") CardColor color) {

        String email=authentication.getName();
        Client client=clientRepository.findByEmail(email);

        if (cardRepository.findByClientAndColorAndType(client,color,type)!=null ) {
            return new ResponseEntity<>("Card already exist", HttpStatus.FORBIDDEN);
        }
        if (clientHasMaxCardsOfType(client, type)){
            return new ResponseEntity<>("Client already has 3 cards registered", HttpStatus.FORBIDDEN);

        }
        int cvvRandom = new Random().nextInt(900)+100;
        String cardHolder=client.getFirstName()+" "+client.getLastName();

        String randomCardNumber;
        do{
            Random random=new Random();
            randomCardNumber=random.nextInt(9999)+"-"+random.nextInt(9999)+"-"+random.nextInt(9999)+"-"+random.nextInt(9999);
        }while(cardRepository.findByNumber(randomCardNumber)!=null);

        Card card=new Card(LocalDate.now(),LocalDate.now().plusYears(5),cvvRandom,randomCardNumber,cardHolder,type,color);
        client.addCard(card);

        cardRepository.save(card);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    private boolean clientHasMaxCardsOfType(Client client, CardType type) {
        long count = client.getCards()
                .stream()
                .filter(card -> card.getType() == type)
                .count();
        return count >= 3;
    }

}