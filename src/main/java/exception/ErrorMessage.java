package exception;

public class ErrorMessage {

    public static final String EMPTY_CAR_NAME = "자동차 이름은 비어있을 수 없습니다.";
    public static final String INVALID_CAR_NAME_LENGTH = "자동차 이름은 5자 이하만 가능합니다.";
    public static final String INVALID_TIMES_INPUT = "정수가 아닌 값이 입력되었거나 int 범위를 벗어났습니다.";
    public static final String NEGATIVE_ATTEMPT_COUNT = "시도 횟수에 음수가 입력되었습니다.";
    public static final String DUPLICATE_CAR_NAME = "자동차 이름이 중복되었습니다.";

    private ErrorMessage() {

    }
}
