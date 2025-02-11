package service;

import domain.Car;

import java.util.List;

public class RacingGameService {
    public void playRacingGame(List<Car> cars, int count) {
        System.out.println("실행 결과");
        printCarsMoving(cars);

        for (int i = 0; i < count; i++) {
            moveCars(cars);
            printCarsMoving(cars);
        }
    }

    public int getLongestMoveDistance(List<Car> cars) {
        List<Integer> distances = cars.stream()
                .map(Car::getMoveDistance)
                .toList();

        return distances.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("carList is empty"));
    }

    public void printWinners(int LongestMoveDistance, List<Car> cars) {
        List<String> winnerNames = cars.stream()
                .filter(car -> car.getMoveDistance() == LongestMoveDistance)
                .map(Car::getName)
                .toList();

        StringBuilder output = new StringBuilder(winnerNames.get(0));

        for (int i = 1; i < winnerNames.size(); i++) {
            output.append(", ").append(winnerNames.get(i));
        }

        System.out.println(output + "가 최종 우승했습니다.");
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.moveForwardOrStay();
        }
    }

    private void printCarsMoving(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        printEmptyLine();
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
