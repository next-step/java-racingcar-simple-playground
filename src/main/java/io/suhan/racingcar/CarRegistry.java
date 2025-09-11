package io.suhan.racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRegistry {
    private final List<Car> cars;

    public CarRegistry() {
        this.cars = new ArrayList<>();
    }

    public void registerCar(Car car) {
        this.cars.add(car);
    }

    public List<Car> getRegisteredCars() {
        return cars;
    }
}
