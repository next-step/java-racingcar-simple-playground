package domain;

public class Round {
    private static final String INVALID_ROUND = "[ERROR] 라운드는 1 이상의 숫자여야 합니다.";

    private final int value;

    public Round(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 1) {
            throw new IllegalArgumentException(INVALID_ROUND);
        }
    }

    public int getValue() {
        return value;
    }
}
