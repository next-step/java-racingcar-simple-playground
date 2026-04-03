import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random random = new Random();
    private static final int MAX_RANDOM_BOUNDARY = 10; // 0~9

    @Override
    public int generate() {
        return random.nextInt(MAX_RANDOM_BOUNDARY);
    }
}