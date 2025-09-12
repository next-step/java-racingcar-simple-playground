package io.suhan.racingcar;

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

    public int getBestPosition() {
        return cars
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }
}
