package domain;

import java.util.Random;

public class RandomGenerator implements NumberGenerator {
    private static final int BOUND = 10;
    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(BOUND);
    }
}
