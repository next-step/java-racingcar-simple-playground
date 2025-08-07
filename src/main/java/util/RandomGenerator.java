package util;

import java.util.Random;

public class RandomGenerator implements NumberGenerator {

    private final Random random = new Random();

    @Override
    public int generate(int bound) {
        return random.nextInt(bound);
    }
}
