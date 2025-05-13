package view;

import java.util.List;
import model.dto.CarProgress;

public class OutputView {
    private static final String RESULT_OF_EXECUTION_HEADER = "실행 결과";

    private OutputView() {
    }

    public static void printResultHeader() {
        System.out.println();
        System.out.println(RESULT_OF_EXECUTION_HEADER);
    }

    public static void printCarProgress(List<CarProgress> progresses) {
        for (CarProgress progress : progresses) {
            System.out.println(progress.name() + " : " + "-".repeat(progress.position()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
