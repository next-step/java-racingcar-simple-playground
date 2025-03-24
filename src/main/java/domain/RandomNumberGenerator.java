package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int BOUND_RANDOM_NUMBER = 10;
    private static final Random random = new Random();

    @Override
    public int generateNumber() {
        return random.nextInt(BOUND_RANDOM_NUMBER);
    }

}
