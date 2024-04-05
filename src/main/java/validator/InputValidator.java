package validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final int MIN_ROUND_COUNT = 1;

    public static void validateDuplicate(List<String> input) {
        Set<String> convertedInput = new HashSet<>(input);
        if (input.size() > convertedInput.size()) {
            throw new IllegalArgumentException("이름이 중복되어선 안됩니다.");
        }
    }

    public static void validateGameCount(int count) {
        if (count < MIN_ROUND_COUNT) {
            throw new IllegalArgumentException("회수는 1 이상이어야 합니다.");
        }
    }

}
