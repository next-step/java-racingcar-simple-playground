package view;

import model.Car;

import java.util.List;

public class OutputView {

    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printCarPosition(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void printCarPosition(Car car) {
        System.out.print("-".repeat(car.getPosition()));
    }

    public static void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
