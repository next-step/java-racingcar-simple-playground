package view;

import model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputController {
    public void printProgressResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPos()));
        }

        System.out.println();
    }

    public void printWinners(List<Car> winnerList) {
        String winnerNames = winnerList.stream()
                                       .map(Car::getName)
                                       .collect(Collectors.joining(", "));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}