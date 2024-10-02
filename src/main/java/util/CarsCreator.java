package util;

import domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CarsCreator {

    public static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName, 0))
                .toList();
    }
}
