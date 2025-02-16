package model;

import java.util.Random;

public class RandomValueGenerator {
    private static final int RANDOM_BOUND = 10;
    private static final Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(RANDOM_BOUND);
    }
}
