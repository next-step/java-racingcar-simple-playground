package io.suhan.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRegistry {
    private final List<Car> cars;

    private CarRegistry() {
        this.cars = new ArrayList<>();
    }

    public static CarRegistry of() {
        return new CarRegistry();
    }

    public void register(Car car) {
        cars.add(car);
    }

    public List<Car> getRegisteredCars() {
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void registerCars(List<String> names) {
        for (String name : names) {
            Car car = Car.of(name);
            cars.add(car);
        }
    }

    public List<Car> getCarsWithBestPosition() {
        int bestPosition = getBestPosition();

        return getRegisteredCars()
                .stream()
                .filter((car) -> car.getPosition() == bestPosition)
                .toList();
    }

    public int getBestPosition() {
        return cars
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }
}
