package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import strategy.MoveStrategy;

public class Cars {
    private static final String CAR_NAME_DELIMITER = ",";

    private final List<Car> cars;

    public Cars(final String names) {
        this.cars = parseToCars(names);
    }

    private List<Car> parseToCars(final String names) {
        return Arrays.stream(names.split(CAR_NAME_DELIMITER))
                .map(name -> new Car(name.trim()))
                .toList();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Integer> getAllPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .toList();
    }

    public List<String> findWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == findMaxPosition())
                .map(Car::getName)
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public void move(final MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.moveForward(moveStrategy);
        }
    }
}
