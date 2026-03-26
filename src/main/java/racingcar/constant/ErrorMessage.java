package racingcar.constant;

public enum ErrorMessage {
    NAME_LENGTH("이름은 1자 이상, 5자 이하여야 합니다."),
    NAME_DUPLICATE("중복된 자동차 이름이 존재합니다."),
    MINIMUM_CAR_COUNT("게임 플레이에는 2명 이상이 필요합니다."),
    INVALID_NUMBER_FORMAT("숫자가 아닌 값이 입력되었습니다."),
    MINIMUM_TRY_COUNT("1번 이상의 시도를 해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
