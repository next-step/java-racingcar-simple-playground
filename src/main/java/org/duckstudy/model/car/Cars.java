package org.duckstudy.model.car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.duckstudy.model.strategy.MovableStrategy;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public Cars(String[] carNames, MovableStrategy movableStrategy) {
        this(Arrays.stream(carNames)
                .map(car -> new Car(car, movableStrategy))
                .collect(Collectors.toList()));
    }

    public Cars moveAll() {
        List<Car> cars = this.cars.stream()
                .map(Car::move)
                .toList();
        return new Cars(cars);
    }

    public Cars calculateWinners() {
        int maxPosition = calculateMaxPosition();
        List<Car> winners = cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .toList();
        return new Cars(winners);
    }

    private int calculateMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalStateException::new);
    }

    public List<Car> toList() {
        return cars;
    }
}
