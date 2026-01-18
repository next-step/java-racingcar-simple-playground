package racingcar.exception;

public class InvalidInputException extends IllegalArgumentException {

    private final InputErrorCode code;

    public InvalidInputException(InputErrorCode code) {
        super(code.message());
        this.code = code;
    }

    public InputErrorCode code() {
        return code;
    }
}
