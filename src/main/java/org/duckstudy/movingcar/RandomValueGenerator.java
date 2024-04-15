package org.duckstudy.movingcar;

import java.util.Random;

public class RandomValueGenerator {

    private final Random random = new Random();

    public int generateRandomValue() {
        return random.nextInt(9);
    }
}
