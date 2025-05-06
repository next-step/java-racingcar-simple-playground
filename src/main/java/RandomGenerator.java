import java.util.Random;

public class RandomGenerator {
    private final Random random = new Random();

    public int getRandomValue() {
        return random.nextInt(10);
    }
}
