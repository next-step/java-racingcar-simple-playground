package domain;

import domain.RandomGenerator;

import java.util.Random;

public class RandomNumberGenerator implements RandomGenerator {
    private static final int MAX_RANDOM_NUM = 9;
    private static final Random random = new Random();
    @Override
    public int generate() {
        return random.nextInt(MAX_RANDOM_NUM + 1);
    }
}