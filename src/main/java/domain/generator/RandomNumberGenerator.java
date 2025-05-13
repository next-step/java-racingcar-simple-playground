package domain.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random random = new Random();
    private static final int MAX_RANDOM_NUMBER = 10;

    @Override
    public int generate() {
        return random.nextInt(MAX_RANDOM_NUMBER);
    }
}
