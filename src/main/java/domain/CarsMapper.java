package domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarsMapper {

    public static Cars mapByCarNames(final NumberGenerateStrategy strategy,
                                     final List<String> carNames) {
        final List<Car> cars = carNames.stream()
                .map(carName -> new Car(strategy, carName))
                .collect(Collectors.toList());
        return new Cars(cars);
    }
}
