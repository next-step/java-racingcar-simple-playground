package util;

import exception.ErrorMessage;

public class TimesValidator {

    public static int validateAndGetTimes(String timesStr) {
        int times = parseTimes(timesStr);

        validatePositiveNumber(times);

        return times;
    }

    private static int parseTimes(String timesStr) {
        try {
            return Integer.parseInt(timesStr);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TIMES_INPUT);
        }
    }

    private static void validatePositiveNumber(int times) {
        if (times < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_ATTEMPT_COUNT);
        }
    }
}
