package view;

import java.util.List;
import java.util.stream.Collectors;

import domain.Car;

public class ResultView {

    public static void printResult(List<Car> carList){
        for (Car car : carList){
            String position = "-".repeat(car.getPosition());
            System.out.println(car.getName() + " : " + position);
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winnerList){
        String winners = winnerList.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println(String.format("%s가 최종 우승했습니다.", winners));
    }
}
