package domain;

public class TryCount {
    private final int value;

    public TryCount(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
