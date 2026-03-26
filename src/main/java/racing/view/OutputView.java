package racing.view;

import racing.domain.Car;
import java.util.List;

public class OutputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_CAR_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public static void printInputCarNameMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public static void printInputTrialCountMessage() {
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
    }

    public static void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    public static void printWinners(List<String> winnerNames) {
        if (winnerNames == null || winnerNames.isEmpty()) {
            return;
        }
        String result = String.join(", ", winnerNames);
        System.out.println(result + "가 최종 우승했습니다.");
    }

    public static void println() {
        System.out.println();
    }
}
