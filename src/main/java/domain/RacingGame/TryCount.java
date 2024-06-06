package domain.RacingGame;

import util.Errors;

public class TryCount {

    private static final int MIN_VALUE_OF_TRY_COUNT = 0;

    private final int tryCount;

    public TryCount(int tryCount) {
        validateRangeOfTryCount(tryCount);
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    private void validateRangeOfTryCount(int input) {
        if (input < MIN_VALUE_OF_TRY_COUNT) {
            throw new IllegalArgumentException(Errors.INPUT_IS_NOT_NATURAL_NUMBER_ERROR);
        }
    }

}
