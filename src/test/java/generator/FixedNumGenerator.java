package generator;

import java.util.LinkedList;
import java.util.List;

public class FixedNumGenerator implements NumberGenerator {
    private LinkedList<Integer> numbers;

    public FixedNumGenerator(List<Integer> numbers) {
        this.numbers = new LinkedList<>(numbers);
    }

    @Override
    public int generate() {
        return numbers.removeFirst();
    }
}
