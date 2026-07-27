package support;

import java.util.List;

import domain.MoveNumberGenerator;

public class SequenceMoveNumberGenerator implements MoveNumberGenerator {
    private final List<Integer> numbers;
    private int index = 0;

    public SequenceMoveNumberGenerator(List<Integer> numbers) {
        this.numbers = List.copyOf(numbers);
    }

    @Override
    public int generate() {
        if (index >= numbers.size()) {
            throw new IllegalStateException("더 이상 생성할 숫자가 없습니다.");
        }

        int number = numbers.get(index);
        index++;

        return number;
    }
}
