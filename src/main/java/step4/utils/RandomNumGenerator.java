package step4.utils;

import java.util.Random;

public class RandomNumGenerator {
    private static final int MAX_BOUND = 10;
    public static int getRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

}
