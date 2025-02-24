package global;

import java.util.Random;

public class RandomNumberGenerator implements RandomUtil {
    private static final int RANDOM_BOUND = 10;
    private static final Random random = new Random();

    @Override
    public int generateRandomNumber() {
        return random.nextInt(RANDOM_BOUND);
    }
}

