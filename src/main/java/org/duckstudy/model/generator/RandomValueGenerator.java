package org.duckstudy.model.generator;

import java.util.Random;

public class RandomValueGenerator implements Generator {

    private static final int EXCLUSIVE_MAX_VALUE = 10;

    public RandomValueGenerator() {
    }

    @Override
    public int generateValue() {
        return new Random().nextInt(EXCLUSIVE_MAX_VALUE);
    }
}
