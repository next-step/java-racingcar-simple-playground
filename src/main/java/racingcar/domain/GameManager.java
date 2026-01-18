package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager {

    private static final int RANDOM_BOUND = 10;
    private static final int MIN_VALUE_TO_MOVE = 4;

    private List<Car> cars;
    private final Random random;

    public GameManager() {
        this.cars = new ArrayList<>();
        this.random = new Random();
    }

    // TODO: parse 시 예외처리하기
    public void setCars(List<String> carNames) {
        this.cars = createCarsFromNames(carNames);
    }

    public List<Car> getCars() {
        return this.cars;
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

    List<Car> createCarsFromNames(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    int getRandomValue() {
        return random.nextInt(RANDOM_BOUND);
    }

    boolean canMove(int randomValue) {
        return randomValue >= MIN_VALUE_TO_MOVE;
    }

    int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
