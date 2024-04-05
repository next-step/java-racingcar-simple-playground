package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public static List<String> parseStringArrayWithComma(String names) {
        if (names == null || names.isEmpty()) {
            return new ArrayList<>(); // 빈 배열 반환
        }
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }

}
