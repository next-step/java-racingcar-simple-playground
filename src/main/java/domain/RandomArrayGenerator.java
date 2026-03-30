package domain;

import java.util.Random;

public class RandomArrayGenerator {
    private static final int RANDOM_INT_BOUND = 10;

    private final Random random;

    public RandomArrayGenerator() {
        this.random = new Random();
    }

    private void validateLength(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("배열의 길이는 0 이하일 수 없습니다.");
        }
    }

    public int[] generateRandomArray(final int length) {
        validateLength(length);
        final int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(RANDOM_INT_BOUND);
        }
        return array;
    }

    public int[][] generateRandom2DArray(final int length1, final int length2) {
        validateLength(length1);
        validateLength(length2);
        final int[][] array = new int[length1][length2];
        for (int i = 0; i < length1; i++) {
            array[i] = generateRandomArray(length2);
        }
        return array;
    }
}
