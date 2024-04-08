package exception;

public enum ErrorMessage {

    NAME_LENGTH_INCORRECT("이름은 최소 %d자, 최대 %d자 입니다."),
    NAME_NOT_DUPLICATED("이름이 중복되어선 안됩니다."),
    GAME_COUNT_MIN("회수는 %d 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String formatMessage(int min, int max) {
        return String.format(this.message, min, max);
    }

    public String formatMessage(int min) {
        return String.format(this.message,min);
    }

    public String getMessage() {
        return message;
    }
}
