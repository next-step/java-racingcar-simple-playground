package org.duckstudy.movingcar;

import java.util.Random;

public class RandomValueGenerator {

    public static final int MAX_RANDOM_VALUE = 9;
    private final Random random = new Random();

    public int generateRandomValue() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }
}
