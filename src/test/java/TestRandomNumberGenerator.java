import model.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class TestRandomNumberGenerator implements RandomNumberGenerator {
    private final List<Integer> randomNumbers;
    private int currentIndex = 0;

    public TestRandomNumberGenerator(List<Integer> randomNumbers) {
        this.randomNumbers = new ArrayList<>(randomNumbers);
    }

    @Override
    public int generate() {
        if (currentIndex >= randomNumbers.size()) {
            throw new IllegalStateException("제공된 수를 모두 사용하여, 더 이상 수를 생성할 수 없습니다.");
        }
        int number = randomNumbers.get(currentIndex);
        currentIndex += 1;

        return number;
    }
}
