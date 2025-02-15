package model;

import java.util.Random;

public interface RandomNumberGenerator {

    int generate();

    class DefaultRandomNumberGenerator implements RandomNumberGenerator {
        private static final int RANDOM_BOUND = 10;
        private final Random random = new Random();

        @Override
        public int generate() {
            return random.nextInt(RANDOM_BOUND);
        }
    }
}
