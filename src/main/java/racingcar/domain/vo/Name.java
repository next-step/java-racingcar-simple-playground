package racingcar.domain.vo;

import racingcar.exception.ApplicationError;
import racingcar.exception.ApplicationException;

public record Name(String value) {

    public Name {
        validateName(value);
    }

    private void validateName(final String name) {
        if (isNullOrEmpty(name)) {
            throw new ApplicationException(ApplicationError.INVALID_NAME_EMPTY);
        }

        if (isTooLong(name)) {
            throw new ApplicationException(ApplicationError.INVALID_NAME_TOO_LONG);
        }
    }

    private boolean isNullOrEmpty(String name) {
        return name == null || name.trim().isEmpty();
    }

    private boolean isTooLong(String name) {
        return name.trim().length() > 5;
    }
}
