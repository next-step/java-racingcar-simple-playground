package factory;

import domain.Car;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static List<Car> createCars(String carNames) {
        return Arrays.stream(carNames.split(","))
            .map(Car::new)
            .collect(Collectors.toList());
    }
}
