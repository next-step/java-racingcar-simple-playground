package racingcar.domain.vo;

import racingcar.exception.ApplicationError;
import racingcar.exception.ApplicationException;

public record Repetition(int value) {

    public static final int MIN_REPETITION = 0;

    public Repetition {
        validateRepetition(value);
    }

    private void validateRepetition(int repetition) {
        if (isUnderMinimumRepetition(repetition)) {
            throw new ApplicationException(ApplicationError.INVALID_REPETITION_NEGATIVE);
        }
    }

    private boolean isUnderMinimumRepetition(int repetition) {
        return repetition < MIN_REPETITION;
    }
}
