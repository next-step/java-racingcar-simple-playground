package view;

import java.util.List;

import domain.Car;

public class ResultView {
    private ResultView() {
    }

    public static void printRaceResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.println(createWinnerNames(winners) + "가 최종 우승했습니다.");
    }

    private static void printCar(Car car) {
        System.out.println(car.getName() + " : " + createPosition(car.getLocation()));
    }

    private static String createPosition(int location) {
        StringBuilder carLocation = new StringBuilder();
        for (int count = 0; count < location; count++) {
            carLocation.append("-");
        }
        return carLocation.toString();
    }

    private static String createWinnerNames(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder();
        for (Car winner : winners) {
            appendWinnerName(winnerNames, winner);
        }
        return winnerNames.toString();
    }

    private static void appendWinnerName(StringBuilder winnerNames, Car winner) {
        if (winnerNames.length() > 0) {
            winnerNames.append(", ");
        }
        winnerNames.append(winner.getName());
    }
}
