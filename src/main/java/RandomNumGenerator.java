public class RandomNumGenerator implements NumberGenerator {
    private static final int MAX_RANDOM_VALUE = 9;

    @Override
    public int generate() {
        return (int) (Math.random() * (MAX_RANDOM_VALUE + 1));
    }
}
