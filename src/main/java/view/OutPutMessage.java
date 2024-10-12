package view;

public enum OutPutMessage {
    ASK_CARS_MESSAGE("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    ASK_TRY_COUNT_MESSAGE("시도할 회수는 몇회인가요?"),
    RESULT_TITLE_MESSAGE("실행 결과"),
    RESULT_DETAIL_MESSAGE("%s : %s"),
    WINNER_MESSAGE("%s가 최종 우승했습니다.");

    private final String message;

    OutPutMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
