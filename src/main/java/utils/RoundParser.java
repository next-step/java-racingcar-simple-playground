package utils;

public class RoundParser {

    public static final String INVALID_ROUND_INPUT = "[ERROR] 시도 횟수는 1 이상의 숫자여야 합니다.";

    public static int parse(String input) {
        int round;

        try {
            round = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ROUND_INPUT);
        }

        validate(round);
        return round;
    }

    private static void validate(int round) {
        if (round < 1) {
            throw new IllegalArgumentException(INVALID_ROUND_INPUT);
        }
    }
}
