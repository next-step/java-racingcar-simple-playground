package view;

import model.Car;
import model.Cars;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printRaceStart() {
        System.out.println("\n실행 결과");
    }

    public static void printStepResult(Cars cars) {
        for (Car car : cars.getCars()) {
            printCarPosition(car);
        }
        System.out.println();
    }

    private static void printCarPosition(Car car) {
        StringBuilder dashes = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            dashes.append("-");
        }
        System.out.println(car.getName() + " : " + dashes.toString());
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}
