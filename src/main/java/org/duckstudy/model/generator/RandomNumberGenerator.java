package org.duckstudy.model.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int EXCLUSIVE_MAX_VALUE = 10;
    private static final Random random = new Random();

    public RandomNumberGenerator() {
    }

    @Override
    public int generateNumber() {
        return random.nextInt(EXCLUSIVE_MAX_VALUE);
    }
}
