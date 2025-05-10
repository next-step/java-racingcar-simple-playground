package model.dto;

import java.util.Arrays;
import java.util.List;

public record CarNamesDto(String names) {
    private static final String CAR_NAME_DELIMITER = ",";

    public List<String> splitNames() {
        return Arrays.stream(names.split(CAR_NAME_DELIMITER))
                .map(String::strip)
                .toList();
    }
}
