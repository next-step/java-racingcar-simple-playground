package racingcar.exception;

public class InvalidInputException extends IllegalArgumentException {

    public InvalidInputException(InputErrorCode code) {
        super(code.message());
    }
}
