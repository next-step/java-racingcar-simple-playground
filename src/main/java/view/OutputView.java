package view;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printWinners(List<Car> winners) {
        String winnersNameString = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnersNameString + "가 최종 우승했습니다.");
    }

    private static void printCarInfo(Car car){
        System.out.printf(car.getName() + " : ");
        for(int i=0;i<car.getDistance();i++)
            System.out.print("-");
        System.out.println();
    }

    public static void printCarsInfo(List<Car> cars) {
        for(Car car : cars){
            printCarInfo(car);
        }
        System.out.println();
    }
}
