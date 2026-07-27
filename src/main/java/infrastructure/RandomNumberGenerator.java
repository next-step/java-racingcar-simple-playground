package infrastructure;

import java.util.Random;

import domain.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int RANDOM_NUMBER_BOUND = 10;

    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
