package view;

import domain.Car;
import domain.Cars;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void printResultHeader() {
        System.out.println("실행 결과");
    }

    public void printStatus(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
