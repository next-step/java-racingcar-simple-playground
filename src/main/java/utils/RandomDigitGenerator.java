package utils;

import java.util.Random;

public class RandomDigitGenerator {
    private Random random = new Random();

    public int generateRandomDigit(){
        return random.nextInt(10);
    }

}