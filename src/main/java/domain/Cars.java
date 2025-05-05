package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void attemptToMoveAll(NumberGenerator generator) {
        cars.forEach(car -> car.move(new MoveCondition(generator)));
    }

    public List<Car> findWinners() {
        int max = maxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == max)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private int maxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
