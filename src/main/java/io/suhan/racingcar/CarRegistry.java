package io.suhan.racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRegistry {
    private final List<Car> cars;

    public CarRegistry() {
        this.cars = new ArrayList<>();
    }

    public void registerCar(Car car) {
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
}
