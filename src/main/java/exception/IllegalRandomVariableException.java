package exception;

public class IllegalRandomVariableException extends RuntimeException {
    public IllegalRandomVariableException() {
    }

    public IllegalRandomVariableException(String message) {
        super(message);
    }
}
