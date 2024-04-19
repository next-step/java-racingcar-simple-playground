package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import validator.InputValidator;

public class CarNameParser {

    public static List<String> parseStringArray(final String names) {
        List<String> parsedNames = parseStringArrayWithComma(names);
        InputValidator.validateDuplicate(parsedNames);
        return parsedNames;
    }

    private static List<String> parseStringArrayWithComma(final String names) {
        if (names == null || names.isEmpty()) {
            return Collections.emptyList(); // 빈 배열 반환
        }
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }

}
