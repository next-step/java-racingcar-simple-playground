package domain.racegame;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random RANDOM = new Random();

    public int generateRandomNumber() {
        return RANDOM.nextInt(10);
    }
}