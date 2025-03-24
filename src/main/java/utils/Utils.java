package utils;

import java.util.Arrays;
import java.util.List;

public class Utils {

    public static List<String> splitByDelimiter(String str, String delimiter) {
        return Arrays.asList(str.split(delimiter));
    }
}
