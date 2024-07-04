package view;

import java.util.List;
import java.util.stream.Collectors;

import model.Car;

public class OutputView {

    public static void printWinner(List<Car> winners) {
        String winnerNames = winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(","));
        System.out.println(String.format("%s가 최종 우승했습니다.", winnerNames));
    }

    public static void printPosition(List<Car> cars) {
        for (Car car: cars) {
            String position = "-".repeat(car.getPosition());
            System.out.println(String.format("%s : %s", car.getName(), position));
        }
        System.out.println('\n');
    }
}
