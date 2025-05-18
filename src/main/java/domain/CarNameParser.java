package domain;

import domain.generator.RandomNumberGenerator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarNameParser {

    public static final String CAR_NAME_DELIMITER = ",";

    public static List<Car> parseCarName(String carNames) {

        List<String> carNameList = Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());

        validateDuplicateCarName(carNameList);

        return carNameList.stream()
                .map(name -> new Car(name.trim(), new RandomNumberGenerator()))
                .collect(Collectors.toList());
    }

    private static void validateDuplicateCarName(List<String> carNameList) {

        Set<String> uniqueCarNames = new HashSet<>(carNameList);

        if (uniqueCarNames.size() != carNameList.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름은 입력할 수 없습니다.");
        }
    }
}
