package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String ONE_STEP = "-";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String ERROR = "[ERROR] ";

    public void printNameGuide() {
        System.out.println("경주할 자동차의 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분)");
    }

    public void printCountGuide() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void printExecutionResultMessage() {
        System.out.println();
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void printCurrentPosition(String name, int position) {
        System.out.print(name + ": ");
        for (int i = 0; i < position; i++) {
            System.out.print(ONE_STEP);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String resultWinners = String.join(", ", winners);
        System.out.println(resultWinners + "가 최종 우승했습니다.");
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR + errorMessage);
    }
}
