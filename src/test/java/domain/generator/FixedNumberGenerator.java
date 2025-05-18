package domain.generator;

public class FixedNumberGenerator implements NumberGenerator {
    private final int[] numbers;
    private int index = 0;

    public FixedNumberGenerator(int... numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        return numbers[index++];
    }

}
