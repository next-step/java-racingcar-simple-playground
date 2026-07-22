package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CarListInitializer {

    public static List<RacingCar> initCarList(String[] names) {
        List<RacingCar> cars = new ArrayList<>();

        nameDuplicateValidation(names);

        for (String name : names) {
            valid(name);
            cars.add(new RacingCar(name));
        }
        return cars;
    }

    private static void valid(String name) {
        nameLengthExceededValidation(name);
        nameNotBlankValidation(name);
    }

    private static void nameNotBlankValidation(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 1 ~ 5글자로 구성된 글자여야 합니다.");
        }
    }

    private static void nameDuplicateValidation(String[] names) {
        if (new HashSet<>(List.of(names)).size() != names.length) {
            throw new IllegalArgumentException("차량의 이름은 중복될 수 없습니다.");
        }
    }

    private static void nameLengthExceededValidation(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
}
