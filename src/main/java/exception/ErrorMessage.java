package exception;

public enum ErrorMessage {

    NAME_LENGTH_INCORRECT("이름은 최소 %d자, 최대 %d자 입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String formatMessage(int min, int max) {
        return String.format(this.message, min, max);
    }

    public String getMessage() {
        return message;
    }
}
