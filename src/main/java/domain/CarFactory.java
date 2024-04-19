package domain;

import java.util.List;
import utils.ValueGenerator;

public class CarFactory {

    public static List<Car> createCars(final List<String> names, final ValueGenerator generator) {
        return names.stream()
                .map(name -> new Car(name, generator))
                .toList();
    }

}
