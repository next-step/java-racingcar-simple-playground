package view;

import domain.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<Car> cars) {
        String winners = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    public void printResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
