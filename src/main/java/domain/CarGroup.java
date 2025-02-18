package domain;

import java.util.List;
import java.util.stream.Collectors;

import util.NumberProvider;

public class CarGroup {

    private final List<Car> cars;
    private final NumberProvider numberProvider;

    public CarGroup(List<Car> cars, NumberProvider numberProvider) {
        this.cars = cars;
        this.numberProvider = numberProvider;
    }

    public void moveCars() {
        cars.forEach(car -> car.move(numberProvider));
    }

    public List<Car> getFarthestCars() {
        int maxPosition = getMaxPosition();
        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }
}
