package step2;

import java.util.Random;

public class randomNumGenerator {
    private static final int MAX_BOUND = 10;
    public static int getRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

}
