package racingcar.domain.vo;

import racingcar.exception.ApplicationError;
import racingcar.exception.ApplicationException;

public record Position(int value) {
    private static final int MIN_VALUE = 0;

    public Position() {
        this(MIN_VALUE);
    }

    public Position {
        validatePosition(value);
    }

    public Position forward() {
        return new Position(value + 1);
    }

    private void validatePosition(int value) {
        if (isNegative(value)) {
            throw new ApplicationException(ApplicationError.INVALID_POSITION_NEGATIVE);
        }
    }

    private boolean isNegative(int value) {
        return value < MIN_VALUE;
    }
}