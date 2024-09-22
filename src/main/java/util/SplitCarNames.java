package util;

import java.util.ArrayList;
import java.util.List;

public class SplitCarNames {
    public static List<String> splitCarNames(String carNames) {
        return new ArrayList<String>(List.of(carNames.split(",")));
    }
}
