package service;

import domain.Car;
import java.util.List;

public class RacingGameService {
    public List<Car> playRacingGame(String[] inputNames, int count) {
        List<Car> cars = Car.getInstancesByNames(inputNames); //InputView, racingGameService, ResultView어디에도 속하지 않는 게임 시작 전 전처리 과정.

        printCarsMoving(cars);

        for (int i = 0; i < count; i++) {
            moveCars(cars);
            printCarsMoving(cars);
        }

        return cars;
    }

    public int getLongestMoveDistance(List<Car> cars) {
        return cars.stream()
                .map(Car::getMoveDistance)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Error because List<Car> is empty"));
    }

    public String[] getWinners(List<Car> cars) {
        int longestMoveDistance = getLongestMoveDistance(cars);
        String[] winners = cars.stream()
                .filter(car -> car.getMoveDistance() == longestMoveDistance)
                .map(Car::getName)
                .toArray(String[]::new);

        return winners;
    }

    public void moveCars(List<Car> cars) {
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
