package view;

import java.util.List;
import model.Cars;
import model.dto.CarProgress;

public class OutputView {
    private final static String RESULT_OF_EXECUTION_HEADER = "실행 결과";

    private OutputView() {
    }

    public static void printResultHeader() {
        System.out.println(RESULT_OF_EXECUTION_HEADER);
    }

    public static void printCarStatus(Cars cars) {
        for (CarProgress status : cars.getCarStatuses()) {
            System.out.println(status.name() + " : " + "-".repeat(status.position()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
