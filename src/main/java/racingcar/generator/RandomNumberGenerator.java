package racingcar.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final Random random = new Random();

    @Override
    public int generateNumber() {
        return random.nextInt(10);
    }
}
