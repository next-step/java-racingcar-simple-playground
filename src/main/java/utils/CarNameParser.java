package utils;

import domain.Name;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameParser {

    private static final String INVALID_INPUT_FORMAT = "[ERROR] 자동차 이름은 쉼표(,)로 구분되어야 하며, 빈 값이 포함될 수 없습니다.";

    public static List<Name> parse(String input) {
        validateRawInput(input);

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(token -> {
                    validateToken(token);
                    return token;
                })
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private static void validateRawInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
    }

    private static void validateToken(String token) {
        if (token.isBlank()) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
    }
}
