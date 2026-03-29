package movingCarGame.util;

import java.util.Random;

public class DefaultRandomGenerator implements RandomGenerator {
    private final Random random = new Random();
    private static final int RANDOM_BOUND = 10;

    @Override
    public int generateRandomValue() {
        return random.nextInt(RANDOM_BOUND);
    }

}
