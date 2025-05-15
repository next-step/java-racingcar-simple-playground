package utils;

public class RoundParser {

    private static final String INVALID_ROUND_INPUT = "[ERROR] 시도 횟수는 숫자여야 합니다.";

    public static int parse(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ROUND_INPUT);
        }
    }
}
