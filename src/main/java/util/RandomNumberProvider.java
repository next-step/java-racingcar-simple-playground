package util;

import java.util.Random;

public class RandomNumberProvider implements NumberProvider {

    private static final int BOUND = 10;
    private final Random random = new Random();

    @Override
    public int provide() {
        return random.nextInt(BOUND);
    }
}
