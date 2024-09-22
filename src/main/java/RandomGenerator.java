import java.util.Random;

public class RandomGenerator {
    private static final int MAX = 10;
    private final Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(MAX);
    }
}
