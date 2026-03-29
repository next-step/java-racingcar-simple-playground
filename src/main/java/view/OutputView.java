package view;

import model.*;

import java.util.List;
import java.util.stream.Collectors;



public class OutputView {
    public static void printResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printRace(List<Car> cars) {
        for (Car car : cars) {
            String dash = "-".repeat(car.getPosition());
            System.out.println(car.getName() + ": " + dash);
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
