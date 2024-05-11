package exception;

public class CarException extends IllegalArgumentException{

    public CarException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public CarException(final String s) {
        super(s);
    }

}
