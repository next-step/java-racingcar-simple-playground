package domain.NumberGeneratorImpl;

import domain.NumberGenerator;
import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random random = new Random();
    private final int MAX_RANDOM_NUMBER = 10;
    private final int MIN_RANDOM_NUMBER = 0;

    @Override
    public int generate() {
        return random.nextInt(MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER) + MIN_RANDOM_NUMBER;
    }
}
