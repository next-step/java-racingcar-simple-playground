package domain;

public class TryCount {
    private final int value;

    public TryCount(String input) {
        int value = parseToInt(input);
        validate(value);
        this.value = value;
    }

    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
