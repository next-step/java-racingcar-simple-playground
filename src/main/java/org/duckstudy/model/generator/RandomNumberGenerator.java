package org.duckstudy.model.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int EXCLUSIVE_MAX_VALUE = 10;

    public RandomNumberGenerator() {
    }

    @Override
    public int generateNumber() {
        return new Random().nextInt(EXCLUSIVE_MAX_VALUE);
    }
}
