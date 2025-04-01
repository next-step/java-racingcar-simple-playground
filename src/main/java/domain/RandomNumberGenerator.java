package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerateStrategy {

    private final static int RANDOM_BOUND = 10;

    private static final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(RANDOM_BOUND);
    }
}
