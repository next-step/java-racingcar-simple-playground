package domain;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {
    private static final String CAR_NAME_DELIMITER = ",";

    public List<String> parse(String carNames) {
        return Arrays.stream(carNames.trim().split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .toList();
    }
}
