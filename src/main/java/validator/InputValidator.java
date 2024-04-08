package validator;

import exception.CarException;
import exception.ErrorMessage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final int MIN_ROUND_COUNT = 1;

    public static void validateDuplicate(List<String> input) {
        Set<String> convertedInput = new HashSet<>(input);
        if (input.size() > convertedInput.size()) {
            throw new CarException(ErrorMessage.NAME_NOT_DUPLICATED);
        }
    }

    public static void validateGameCount(int count) {
        if (count < MIN_ROUND_COUNT) {
            throw new CarException(ErrorMessage.GAME_COUNT_MIN.formatMessage(MIN_ROUND_COUNT));
        }
    }

}
