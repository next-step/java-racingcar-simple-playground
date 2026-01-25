package util;

import domain.Car;

import java.util.Arrays;
import java.util.List;

public final class CarsFactory {
    private static final String DELIMITER = ",";

    public List<Car> from(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Car::new)
                .toList();
    }
}
