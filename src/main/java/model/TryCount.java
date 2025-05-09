package model;

public record TryCount(int value) {
    private static final int MIN_TRY_COUNT = 1;

    public TryCount {
        validateTryCount(value);
    }

    private void validateTryCount(final int value) {
        if (value < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상을 입력해주세요.");
        }
    }
}
