package domain.RacingGame;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int UPPER_BOUND_OF_RANDOM_NUMBER = 10;

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(UPPER_BOUND_OF_RANDOM_NUMBER);
    }
}
