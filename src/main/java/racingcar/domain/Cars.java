package racingcar.domain;

import java.util.List;
import java.util.Random;
import racingcar.exception.InputErrorCode;
import racingcar.exception.InvalidInputException;

public final class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new InvalidInputException(InputErrorCode.CAR_NAMES_BAD_FORMAT);
        }
        return new Cars(getCarsFromNames(carNames));
    }

    public List<Car> asUnmodifiableList() {
        return List.copyOf(cars);
    }

    public void raceOneRound(Random random, int bound, int minValueToMove) {
        for (Car car : cars) {
            int randomValue = random.nextInt(bound);

            if (randomValue >= minValueToMove) {
                car.moveForward();
            }
        }
    }

    public List<Car> winners() {
        int maxPosition = getMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private static List<Car> getCarsFromNames(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
