package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRoundResult(Map<String, Integer> roundResult) {
        for (Map.Entry<String, Integer> entry : roundResult.entrySet()) {
            System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winnerNames) {
        String names = String.join(", ", winnerNames);
        System.out.println(names + "가 최종 우승했습니다.");
    }
}
