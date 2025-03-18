package CarGame2;

import java.util.Random;

public class RandomGenerator implements Generator {

    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(10);
    }
}
