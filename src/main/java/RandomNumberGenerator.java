import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int RANDOM_UPPER_BOUND_EXCLUSIVE = 10;
    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(RANDOM_UPPER_BOUND_EXCLUSIVE);
    }
}
