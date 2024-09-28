package domain;

import java.util.*;

public class RandomNumberGenerateStrategy implements NumberGenerateStrategy {

    private final Random random = new Random();
    public static final int RANDOM_VALUE_MAX = 10;

    @Override
    public int generate() {
        return random.nextInt(RANDOM_VALUE_MAX);
    }
}
