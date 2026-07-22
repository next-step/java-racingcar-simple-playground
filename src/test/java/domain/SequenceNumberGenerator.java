package domain;

import java.util.Iterator;
import java.util.List;

class SequenceNumberGenerator implements NumberGenerator {

    private final Iterator<Integer> numbers;

    SequenceNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers.iterator();
    }

    @Override
    public int generate() {
        return numbers.next();
    }
}