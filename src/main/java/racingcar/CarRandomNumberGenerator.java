package racingcar;

import java.util.concurrent.ThreadLocalRandom;

public class CarRandomNumberGenerator implements RandomNumberGenerator {

    @Override
    public int generate() {
        return ThreadLocalRandom.current().nextInt(0, 9);
    }
}
