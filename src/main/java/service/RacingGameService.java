package service;

import domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGameService {

    private static final int MINIMUM_GAME_COUNT = 1;
    private static final String INPUT_SEPARATOR = ",";
    private static final int LOWER_LIMIT_OF_FORWARD_CAPABLE = 4;

    public String[] splitInputCarNames(String inputCarNames) {
        return inputCarNames.split(INPUT_SEPARATOR);
    }

    public List<Car> createCarsFromNames(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(Car.from(name));
        }

        return Collections.unmodifiableList(cars);
    }

    public void validateGameCount(int gameCount) {
        if (isIllegalGameCount(gameCount)) {
            throw new IllegalArgumentException(String.format("시도 횟수는 %d보다 작을 수 없습니다.", MINIMUM_GAME_COUNT));
        }
    }

    public void proceedCar(Car car, int goForwardDecider) {
        if (isForwardCapable(goForwardDecider)) {
            car.goForward();
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

    private boolean isIllegalGameCount(int gameCount) {
        return gameCount < MINIMUM_GAME_COUNT;
    }

    private boolean isForwardCapable(int randomNumber) {
        return randomNumber >= LOWER_LIMIT_OF_FORWARD_CAPABLE;
    }
}
