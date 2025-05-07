import java.util.Random;

public class RandomGenerator {
    private static final int MAX_RANDOM_BELOW = 10;

    private final Random random = new Random();

    public int getRandomValue() {
        return random.nextInt(MAX_RANDOM_BELOW);
    }
}
