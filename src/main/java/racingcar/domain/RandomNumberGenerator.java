package racingcar.domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    @Override
    public int generate() {
        return ThreadLocalRandom.current().nextInt(START_INCLUSIVE, END_INCLUSIVE + 1);
    }
}
