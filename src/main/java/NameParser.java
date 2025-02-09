import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameParser {
    public List<String> parseName(String str) {
        return Arrays.stream(str.split(",", -1)).toList();
    }
}
