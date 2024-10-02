package domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomValueRule implements Rule {
    private final ThreadLocalRandom rd;
    private static final int RANDOM_BOUND = 10;

    public RandomValueRule() {
        rd = ThreadLocalRandom.current();
    }

    public boolean canGo() {
        return rd.nextInt(RANDOM_BOUND) >= 4;
    }
}
