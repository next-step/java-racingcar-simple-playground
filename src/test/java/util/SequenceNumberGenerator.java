package util;

import java.util.List;

import domain.NumberGenerator;

public class SequenceNumberGenerator implements NumberGenerator {
    private final List<Integer> numbers;
    private int index = 0;

    public SequenceNumberGenerator(List<Integer> numbers) {
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
