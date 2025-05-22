package domain.car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameParser {
    public static List<String> nameParse(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값은 비워둘 수 없습니다.");
        }
        return Arrays.stream(input.split(","))
            .map(String::trim)
            .map(name -> name.replaceAll("\\s+", "")) //이름 내부 공백 제거
            .filter(name -> !name.isEmpty())
            .collect(Collectors.toList());
    }
}
