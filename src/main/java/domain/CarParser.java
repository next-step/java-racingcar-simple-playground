package domain;

import java.util.Arrays;
import java.util.List;

public class CarParser {
    public static List<Car> parsing(String input) {
        if (!isValidInput(input)) throw new IllegalArgumentException("올바르지 않은 입력 형식입니다.");

        return Arrays.stream(input.split(","))
                .map(name -> {
                    if (!isValidLength(name)) throw new IllegalArgumentException("자동차 이름은 1글자 이상 5글자 이하여야 합니다.");
                    return new Car(name);
                })
                .toList();
    }

    private static boolean isValidInput(String input) {
        return input.matches("^([가-힣\\w][,가-힣\\w]*[가-힣\\w])$");
    }

    private static boolean isValidLength(String name) {
        return name.length() > 0 && name.length() <= 5;
    }
}
