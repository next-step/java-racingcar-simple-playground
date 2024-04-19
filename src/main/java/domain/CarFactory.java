package domain;

import java.util.List;

public class CarFactory {

    public static List<Car> createCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .toList();
    }

}
