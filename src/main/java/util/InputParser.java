package util;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String CAR_NAME_DELIMITER = ",";

    public static List<String> parseCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }

        String[] names = input.split(CAR_NAME_DELIMITER);

        if (names.length < 2) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }

        List<String> trimmedNames = Arrays.stream(names)
            .map(String::trim)
            .toList();

        if (trimmedNames.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException("빈 자동차 이름이 존재합니다.");
        }

        return trimmedNames;
    }

    public static int parseNumberOfRounds(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("회수는 비어있을 수 없습니다.");
        }

        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("회수는 숫자여야 합니다.");
        }

        int rounds = Integer.parseInt(input);

        if (rounds <= 0) {
            throw new IllegalArgumentException("회수는 0보다 커야 합니다.");
        }

        return rounds;
    }
}
