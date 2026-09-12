package racingcar;

import java.util.List;

public class TestNumberGenerator implements NumberGenerator {
    private final List<Integer> numbers;
    private int index = 0;

    public TestNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        int number = this.numbers.get(index);
        index++;
        return number;
    }
}
