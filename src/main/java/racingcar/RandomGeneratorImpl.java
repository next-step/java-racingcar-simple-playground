package racingcar;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGeneratorImpl implements RandomGenerator {
    public int generate() {
        return ThreadLocalRandom.current().nextInt(0, 9);
    }
}
