package racingcar.util;

import java.util.Random;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {
    private static final int MIN = 0;
    private static final int MAX = 9;
    private final Random random;

    public DefaultRandomNumberGenerator() {
        this.random = new Random();
    }

    @Override
    public int generate() {
        return random.nextInt(MAX - MIN + 1) + MIN;
    }
}
