package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final Random random = new Random();

    private static final int MAX_BOUND = 10;

    @Override
    public int getNumber() {
        return  random.nextInt(MAX_BOUND);
    }

}
