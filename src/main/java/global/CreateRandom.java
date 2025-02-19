package global;

import java.util.Random;

public class CreateRandom {
    private static final Random random = new Random();
    public static int getRandomNumber() {
        return random.nextInt(10);
    }
}
