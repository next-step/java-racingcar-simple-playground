package util;

import java.util.ArrayList;
import java.util.List;

public class SplitCarNames {
    private static final String SPLIT_CHARACTERS = ",";

    public static List<String> splitCarNames(String carNames) {
        return new ArrayList<String>(List.of(carNames.split(SPLIT_CHARACTERS)));
    }
}
