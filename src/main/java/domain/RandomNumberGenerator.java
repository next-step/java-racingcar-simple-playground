package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 10;

    private final Random random;

    public RandomNumberGenerator() {
        this(new Random());
    }

    public RandomNumberGenerator(Random random) {
        this.random = random;
    }

    @Override
    public int getNumber() {
        int number = random.nextInt(MAX_BOUND);
        validateNumber(number);
        return number;
    }

    private void validateNumber(int number) {
        if (number < MIN_BOUND || number >= MAX_BOUND) {
            throw new IllegalArgumentException("랜덤값은 0에서 9 사이여야 합니다.");
        }
    }
}
