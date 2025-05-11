package model;

import java.util.List;
import strategy.MoveStrategy;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
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
