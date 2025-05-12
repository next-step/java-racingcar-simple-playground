package domain;

import java.util.Random;

public class RandomNumber {
    private static final Random random = new Random();

    public static int numberStatus() {
        return random.nextInt(9) + 1;
    }
}
