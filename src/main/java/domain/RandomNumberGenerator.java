package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    @Override
    public int getNumber() {
        return random.nextInt(10); // 0~9를 반환하도록 구현
    }
}
