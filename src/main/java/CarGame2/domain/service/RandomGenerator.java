package CarGame2.domain.service;

import java.util.Random;

public class RandomGenerator implements Generator {

    private static final int MAX_RANDOM_NUMBER = 10;
    private final Random random = new Random();

    @Override
    public int NumberGenerate() {
        return random.nextInt(MAX_RANDOM_NUMBER);
    }
}
