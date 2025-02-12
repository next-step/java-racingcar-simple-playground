package view;

import model.Car;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printRaceResult() {
        System.out.println("실행 결과");
    }

    public static void printRaceStatus(List<Car> cars) {
        cars.forEach(car ->
                System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()))
        );
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnersNames = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));

        System.out.println(winnersNames + "가 최종 우승했습니다.");
    }
}
