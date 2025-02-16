package domain;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveCars(Supplier<Boolean> shouldMove) {
        cars.stream()
                .filter(car -> shouldMove.get())
                .forEach(Car::move);
    }

    public Car getMaxPositionCar() {
        return cars.stream()
                .max(Car::comparePositionOfCarObject)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<String> getWinnerCarNames() {
        Car maxPositionCar = getMaxPositionCar();
        return cars.stream()
                .filter(car -> car.isEqualPosition(maxPositionCar))
                .map(Car::getCarName)
                .collect(Collectors.toUnmodifiableList());
    }

}
