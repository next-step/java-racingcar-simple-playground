package util;

import java.util.Arrays;
import java.util.List;

public class NameParser {

    public static List<String> parse(String nameStr) {
        return Arrays.stream(nameStr.split(",", -1)).toList();
    }
}
