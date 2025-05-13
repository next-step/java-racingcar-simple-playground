package racingcar.util;

public class TestRandomNumberGenerator implements RandomNumberGenerator {

    private final int[] values;
    private int index;

    public TestRandomNumberGenerator(final int[] values) {
        this.values = values;
        this.index = 0;
    }

    @Override
    public int generate() {
        if (index >= values.length) {
            index = 0;
        }

        return values[index++];
    }
}
