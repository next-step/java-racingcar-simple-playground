package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int EXCLUSIVE_LIMIT = 10;

    private final Random random = new Random();

    @Override
    public int generateNumber() {
        return random.nextInt(EXCLUSIVE_LIMIT);
    }
}
