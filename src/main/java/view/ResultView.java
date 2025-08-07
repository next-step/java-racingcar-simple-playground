package view;

import domain.Car;
import java.util.List;

public class ResultView {

    public static void printRaceStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + createPositionDisplay(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    private static String createPositionDisplay(int position) {
        StringBuilder display = new StringBuilder();
        for (int i = 0; i < position; i++) {
            display.append("-");
        }
        return display.toString();
    }
}
