package racingcar.exception;

public enum InputErrorCode {
    CAR_NAMES_BAD_FORMAT("자동차 이름 입력 형식이 올바르지 않습니다."),
    CAR_NAME_TOO_LONG("자동차 이름은 5자 이하여야 합니다."),
    CAR_NAME_BLANK("자동차 이름은 비어 있을 수 없습니다."),
    CAR_NAME_DUPLICATED("중복된 자동차 이름이 존재합니다."),

    ATTEMPT_NOT_NUMBER("시도 횟수는 숫자여야 합니다."),
    ATTEMPT_NOT_POSITIVE("시도 횟수는 1 이상이어야 합니다."),
    ATTEMPT_TOO_LARGE("시도 횟수는 1000 미만이어야 합니다.");

    private final String message;

    InputErrorCode(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
