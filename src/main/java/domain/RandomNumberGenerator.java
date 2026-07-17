package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    //private static final int MIN_VALUE = 0;
    //private static final int MAX_VALUE = 10;

    private final Random random; // Random 객체

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    @Override
    public int getNumber() {
        return random.nextInt(10);
    }
}
