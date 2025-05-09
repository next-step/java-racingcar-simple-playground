package domain;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {
    private final String DELIMITER = ",";

    public List<String> parse(String carNames) {
        return Arrays.stream(carNames.trim().split(DELIMITER))
                .map(String::trim)
                .toList();
    }
}
