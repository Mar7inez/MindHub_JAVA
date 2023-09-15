package com.mindhub.homebanking.utils;

import java.util.Random;

public final class CardUtils {
    public static int randomNumber(int numberDigits){
        return new Random().nextInt(numberDigits);
    }
}
