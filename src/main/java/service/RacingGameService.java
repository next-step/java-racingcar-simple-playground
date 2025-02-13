package service;

import domain.Car;

import java.util.List;

public class RacingGameService {

    private static final String INPUT_SEPARATOR = ",";

    public String[] splitInputCarNames(String inputCarNames) {
        return inputCarNames.split(INPUT_SEPARATOR);
    }

    public void proceedRace(List<Car> cars) {
        for (Car car : cars) {
            car.mightGoForward();
        }
    }

    public int getLongestMoveDistance(List<Car> cars) {
        return cars.stream()
                .map(Car::getMoveDistance)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("전달된 Car 리스트가 비어 있습니다."));
    }

    public List<Car> getWinners(List<Car> cars, int LongestMoveDistance) {
        return cars.stream()
                .filter(car -> car.getMoveDistance() == LongestMoveDistance)
                .toList();
    }
}
