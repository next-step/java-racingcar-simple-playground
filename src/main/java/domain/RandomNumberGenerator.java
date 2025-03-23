package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerateStrategy {

    private final static int RANDOM_BOUND = 10;

    @Override
    public int generate() {
        final Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }
}
