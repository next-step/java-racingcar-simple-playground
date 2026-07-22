package view;

import domain.Car;

import java.util.List;

public class ResultView {

    public static void printRaceResults(List<List<Car>> raceResults) {
        System.out.println("\n실행 결과");
        for (List<Car> cars : raceResults) {
            printCars(cars);
            System.out.println();
        }
    }

    private static void printCars(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
    }

    private static void printCar(Car car) {
        System.out.println(
                car.getName() + " : " + "-".repeat(car.getPosition())
        );
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
