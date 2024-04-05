package domain;

import java.util.Random;

public class RandomNumberGenerateStrategy implements NumberGenerateStrategy {

    @Override
    public int generate() {
        final Random random = new Random();
        return random.nextInt(10);
    }
}
