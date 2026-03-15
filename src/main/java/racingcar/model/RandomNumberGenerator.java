package racingcar.model;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final Random random = new Random();
    private static final int MAX_RANGE = 10;

    @Override
    public int generateNumber() {
        return random.nextInt(MAX_RANGE);
    }
}
