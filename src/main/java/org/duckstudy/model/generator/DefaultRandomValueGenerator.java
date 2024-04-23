package org.duckstudy.model.generator;

import java.util.Random;

public class DefaultRandomValueGenerator implements RandomValueGenerator {

    private static final int EXCLUSIVE_MAX_VALUE = 10;

    public DefaultRandomValueGenerator() {
    }

    @Override
    public int generateRandomValue() {
        return new Random().nextInt(EXCLUSIVE_MAX_VALUE);
    }
}
