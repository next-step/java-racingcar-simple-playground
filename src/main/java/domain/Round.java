package domain;

public class Round {
    private static final int MAX_ROUND = 100;

    private final int value;

    private Round(int value) {
        validate(value);
        this.value = value;
    }

    public static Round from(String input) {
        try {
            return new Round(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니댜.");
        }
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

        if (value > MAX_ROUND) {
            throw new IllegalArgumentException("시도 횟수는 " + MAX_ROUND + " 이하여야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
