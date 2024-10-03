package domain.racegame;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random RANDOM = new Random();

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static int generateRandomNumber() {
        return RANDOM.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }
}
