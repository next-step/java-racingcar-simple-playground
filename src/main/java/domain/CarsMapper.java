package domain;

import java.util.*;
import java.util.stream.Collectors;

public class CarsMapper {
    public static Cars mapByCarNames(final NumberGenerateStrategy strategy, final List<String> carNames) {
        final List<Car> cars = carNames.stream()
                .map(carName -> Car.fromStart(strategy, carName))
                .collect(Collectors.toList());
        return new Cars(cars);
    }
}
