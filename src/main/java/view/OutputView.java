package view;

import domain.Car;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printProcess(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(formmatCarInfo(car));
        }
        System.out.println();
    }

    public static String formmatCarInfo(Car car) {
        StringBuilder formatted;
        formatted = new StringBuilder(car.getName() + " : ");
        for (int i = 0; i < car.getDistance(); i++) {
            formatted.append("-");
        }
        return formatted.toString();
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        System.out.println(formattWinnerNames(winnerNames) + "가 최종 우승했습니다.");
    }

    public static String formattWinnerNames(List<String> cars) {
        return cars.toString().replace("[", "").replace("]", "");
    }
}
