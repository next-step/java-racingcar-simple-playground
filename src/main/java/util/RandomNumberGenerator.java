package util;

import java.util.Random;

import domain.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        Random random = new Random();

        int number = random.nextInt(10);

        return number;
    }
}
