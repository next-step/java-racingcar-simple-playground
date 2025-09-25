package io.suhan.racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RoundResult {
    private final List<Car> cars;

    private RoundResult(List<Car> cars) {
        this.cars = cars;
    }

    public static RoundResult of(List<Car> cars) {
        List<Car> copied = cars.stream().map(Car::copy).collect(Collectors.toList());

        return new RoundResult(copied);
    }

    public List<Car> getCars() {
        return cars;
    }
}
