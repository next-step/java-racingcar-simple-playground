package view;

import dto.CarDto;
import java.util.List;

public class OutputView {
    public static void printResultMessage() {
        printNewLine();
        System.out.println("실행 결과");
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String result = String.join(",", winners);
        System.out.println(result + "가 최종 우승했습니다.");
    }

    public static void printAllCar(List<CarDto> cars) {
        for (CarDto car : cars) {
            System.out.println(car.name() + " : " + "-".repeat(car.distance()));
        }

    }
}
