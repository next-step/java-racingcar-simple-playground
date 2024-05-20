package model;

public class RacingCount {

    public static final int ZERO = 0;
    private final int value;

    public RacingCount(final int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(final int value) {
        if (value <= ZERO) {
            throw new IllegalArgumentException("레이싱 횟수는 0보다 커야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
