public class RandomNumberGenerator implements NumberGenerator {
    private static final int RANDOM_UPPER_BOUND_EXCLUSIVE = 10;

    @Override
    public int generate() {
        return (int) (Math.random() * RANDOM_UPPER_BOUND_EXCLUSIVE);
    }
}
