package util;

import java.util.List;

public class Validator {

    public static void validateParticipantNames(List<String> names) {
        for (String name : names) {
            validateLengthOfParticipantName(name);
        }
    }

    private static void validateLengthOfParticipantName(String name) {
        if (name.length() > Constants.MAX_LENGTH_OF_RACING_CAR_NAME) {
            throw new IllegalArgumentException(Errors.getLengthOfCarNameError(name));
        }
    }

    public static void validateRangeOfTryCount(int input) {
        if (input < Constants.MIN_VALUE_OF_TRY_COUNT) {
            throw new IllegalArgumentException(Errors.INPUT_IS_NOT_NATURAL_NUMBER_ERROR);
        }
    }


}
