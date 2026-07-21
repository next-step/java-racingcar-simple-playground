package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int RANDOM_BOUND = 10;
    private final Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    @Override
    public int getNumber() {
        return random.nextInt(RANDOM_BOUND);
    }
}
