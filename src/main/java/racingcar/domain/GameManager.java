package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.exception.InputErrorCode;
import racingcar.exception.InvalidInputException;

public class GameManager {

    private static final int RANDOM_BOUND = 10;
    private static final int MIN_VALUE_TO_MOVE = 4;

    private List<Car> cars;
    private final Random random;

    public GameManager() {
        this.cars = new ArrayList<>();
        this.random = new Random();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void createCars(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new InvalidInputException(InputErrorCode.CAR_NAMES_BAD_FORMAT);
        }
        this.cars = getCarsFromNames(carNames);
    }

    public void raceOneRound() {
        for (Car car : cars) {
            move(car, getRandomValue());
        }
    }

    public void move(Car car, int randomValue) {
        if (canMove(randomValue)) {
            car.moveForward();
        }
    }

    public List<Car> getWinCars(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private List<Car> getCarsFromNames(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private int getRandomValue() {
        return random.nextInt(RANDOM_BOUND);
    }

    private boolean canMove(int randomValue) {
        return randomValue >= MIN_VALUE_TO_MOVE;
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
