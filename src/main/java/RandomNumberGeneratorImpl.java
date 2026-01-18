import java.util.Random;

public final class RandomNumberGeneratorImpl implements RandomNumberGenerator {
    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(10);
    }
}