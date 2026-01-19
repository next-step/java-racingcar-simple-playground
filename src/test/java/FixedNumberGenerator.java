import domain.RandomNumberGenerator;

public final class FixedNumberGenerator implements RandomNumberGenerator {
    private final int number;

    public FixedNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}