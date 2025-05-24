package domain;

import java.util.Random;

public class GeneratedRandInt implements NumberGenerator {

    private final Random random = new Random();

    @Override
    public int generateInt() {
        return random.nextInt(10);
    }
}
