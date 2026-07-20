package domain;

import java.util.List;

public class SequenceNumberGenerator implements NumberGenerator {
    private final List<Integer> numbers;
    private int index = 0;

    public SequenceNumberGenerator(Integer... numbers) {
        this.numbers = List.of(numbers);
    }

    @Override
    public int generate() {
        return numbers.get(index++);
    }
}
