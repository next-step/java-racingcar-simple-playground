package racingcar.exception;

public enum ApplicationError {

    /* name exception */
    INVALID_NAME_EMPTY("이름은 빈 값이 작성될 수 없습니다."),
    INVALID_NAME_TOO_LONG("이름은 5자 이하만 가능합니다."),

    /* position exception */
    INVALID_POSITION_NEGATIVE("위치는 음수가 될 수 없습니다."),

    /* repetition exception */
    INVALID_REPETITION_NEGATIVE("반복 횟수는 최소 0 이상의 양수를 입력해주세요."),

    /* cars exception */
    DUPLICATE_NAME("중복된 이름이 존재합니다.");

    private final String description;

    ApplicationError(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
