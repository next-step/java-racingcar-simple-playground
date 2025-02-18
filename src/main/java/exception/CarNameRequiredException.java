package exception;

public class CarNameRequiredException extends IllegalArgumentException {

    public CarNameRequiredException(String message) {
        super(message);
    }
}
