package view;

import domain.Car;

import java.util.List;

public class ResultView {

    public void printRaceResults(List<List<Car>> raceResults) {
        System.out.println("\n실행 결과");

        for (List<Car> cars : raceResults) {
            printCars(cars);
            System.out.println();
        }
    }

    private void printCars(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
    }

    private void printCar(Car car) {
        String position = "-".repeat(car.getPosition());
        System.out.println(car.getName() + " : " + position);
    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }
}