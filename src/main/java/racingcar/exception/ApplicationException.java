package racingcar.exception;

public class ApplicationException extends RuntimeException {
    public ApplicationException(ApplicationError error) {
        super(error.getDescription());
    }
}
