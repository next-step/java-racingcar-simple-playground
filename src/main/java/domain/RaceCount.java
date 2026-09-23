package domain;

public class RaceCount {
    private final int value;

    public RaceCount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("경주 횟수는 1 이상이어야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
