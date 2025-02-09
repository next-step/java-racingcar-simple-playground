package exception;

public class CarNameTooLongException extends IllegalArgumentException {

    public CarNameTooLongException(String message) {
        super(message);
    }
}
