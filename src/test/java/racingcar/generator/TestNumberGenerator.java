package racingcar.generator;

import java.util.List;

public class TestNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;
    private int index;

    public TestNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        int number = numbers.get(index);
        index++;
        return number;
    }
}
