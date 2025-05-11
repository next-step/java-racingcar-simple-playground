package view;

import java.util.List;
import model.Car;
import model.Cars;

public class OutputView {
    private final static String RESULT_OF_EXECUTION_HEADER = "실행 결과";

    private OutputView() {
    }

    public static void printResultHeader() {
        System.out.println(RESULT_OF_EXECUTION_HEADER);
    }

    public static void printCarStatus(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
