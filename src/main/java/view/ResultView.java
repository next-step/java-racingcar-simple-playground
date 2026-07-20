package view;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String names = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(names + "가 최종 우승했습니다.");
    }
}
