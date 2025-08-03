package util;

import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    public static int getRandomValue(int lowerBound, int upperBound) {
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }
}
