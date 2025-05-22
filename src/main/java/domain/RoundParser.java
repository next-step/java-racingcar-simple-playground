package domain;

public class RoundParser {
    public static int parseRound(String input) {
        validateInputNotEmpty(input);

        try {
            int round = Integer.parseInt(input.trim());
            validateRoundNumber(round);
            return round;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }

    private static void validateInputNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다. 라운드 수를 입력해주세요.");
        }
    }

    private static void validateRoundNumber(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException("라운드 수는 1 이상이어야 합니다.");
        }
    }
}
