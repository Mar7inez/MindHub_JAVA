package com.mindhub.homebanking.utils;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CardUtilsTest {
    @Test
    public void cardNumberIsCreated(){
        String cardNumber = CardUtils.randomNumber(9999) + " " +
                CardUtils.randomNumber(9999) + " " +
                CardUtils.randomNumber(9999) + " " +
                CardUtils.randomNumber(9999);
        assertThat(cardNumber,is(not(emptyOrNullString())));

    }

    @Test
    public void getCVV(){
        String cvvCode = CardUtils.randomNumber(999)+ "" ;
        assertThat(cvvCode,is(not(emptyOrNullString())));

    }

    @Test
    public void IsThreeDigitCVV(){
        String cvvCode = CardUtils.randomNumber(999)+ "" ;
        assertThat(cvvCode.length(), equalTo(3));

    }
}