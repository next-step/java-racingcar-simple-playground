package util;

import java.util.Random;

public class GenerateNumber {
    private static final Random random = new Random();

    public static int generateNumber() {
        return random.nextInt(10);
    }
}
