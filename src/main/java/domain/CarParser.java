package domain;

import java.util.Arrays;
import java.util.List;

public class CarParser {
    public static List<Car> parsing(String input) {
        if (!isValidInput(input)) throw new IllegalArgumentException("올바르지 않은 입력 형식입니다.");

        List<Car> cars = Arrays.stream(input.split(","))
                .map(name -> {
                    if (!isValidLength(name)) throw new IllegalArgumentException("자동차 이름은 1글자 이상 5글자 이하여야 합니다.");
                    return new Car(name);
                })
                .toList();

        if(isDuplicatedName(cars)) throw new IllegalArgumentException("중복된 자동차 이름은 입력될 수 없습니다.");

        return cars;
    }

    private static boolean isDuplicatedName(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .distinct()
                .count() != cars.size();
    }

    private static boolean isValidInput(String input) {
        return input.matches("^([가-힣\\w][,가-힣\\w]*[가-힣\\w])$");
    }

    private static boolean isValidLength(String name) {
        return name.length() > 0 && name.length() <= 5;
    }
}
