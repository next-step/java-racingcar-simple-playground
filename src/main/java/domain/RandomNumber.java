package domain;

import java.util.Random;

public class RandomNumber implements Number {
    private final Random random = new Random();

    @Override
    public int getNumber() {
        return random.nextInt(10);
    }
}
