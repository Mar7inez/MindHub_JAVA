package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.CardColor;
import com.mindhub.homebanking.models.CardType;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.CardRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.services.CardService;
import com.mindhub.homebanking.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class CardController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private CardService cardService;
    @PostMapping(path = "/clients/current/cards")
    public ResponseEntity<?> createCard( Authentication authentication,
                                         @RequestParam CardType type,
                                         @RequestParam CardColor color) {

        String email = authentication.getName();
        Client client = clientService.findByEmail(email);
        if(type == null ){
            return new ResponseEntity<>("Select card type please", HttpStatus.FORBIDDEN);
        }
        if(color == null){
            return new ResponseEntity<>("Select card color please", HttpStatus.FORBIDDEN);
        }
        if (cardService.findByClientAndColorAndType(client,color,type)!=null ) {
            return new ResponseEntity<>("Card already exist", HttpStatus.FORBIDDEN);
        }
        int cvvRandom = new Random().nextInt(900)+100;
        String cardHolder = client.getFirstName()+" "+client.getLastName();

        String randomCardNumber;
        do{
            Random random = new Random();
            randomCardNumber = random.nextInt(9999)+"-"+random.nextInt(9999)+"-"+random.nextInt(9999)+"-"+random.nextInt(9999);
        }while(cardService.findByNumber(randomCardNumber)!=null);

        Card card = new Card(LocalDate.now(),LocalDate.now().plusYears(5),cvvRandom,randomCardNumber,cardHolder,type,color);
        client.addCard(card);
        cardService.saveCard(card);
        return new ResponseEntity<>("Card created",HttpStatus.CREATED);
    }


}