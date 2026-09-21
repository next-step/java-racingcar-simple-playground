package domain;

import java.util.List;

class FixedNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;
    private int index;

    FixedNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
        this.index = 0;
    }

    @Override
    public int generate() {
        int number = numbers.get(index);
        index++;

        return number;
    }
}
