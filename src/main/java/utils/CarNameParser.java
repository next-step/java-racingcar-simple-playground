package utils;

import domain.Name;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameParser {

    public static final String INVALID_INPUT_FORMAT = "[ERROR] 자동차 이름은 쉼표(,)로 구분되어야 하며, 빈 값이 포함될 수 없습니다.";

    public static List<Name> parse(String input) {
        List<String> tokens = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        validate(tokens);
        return tokens.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private static void validate(List<String> tokens) {
        validateNotEmpty(tokens);
        validateNoBlankName(tokens);
    }

    private static void validateNotEmpty(List<String> tokens) {
        if (tokens.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
    }

    private static void validateNoBlankName(List<String> tokens) {
        boolean hasBlank = tokens.stream().anyMatch(String::isEmpty);
        if (hasBlank) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
    }
}
