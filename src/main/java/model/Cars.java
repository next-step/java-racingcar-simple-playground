package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final String CAR_NAME_DELIMITER = ",";

    private final List<Car> cars;

    public Cars(final String names) {
        this.cars = parseToCars(names);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private List<Car> parseToCars(final String names) {
        return Arrays.stream(names.split(CAR_NAME_DELIMITER))
                .map(name -> new Car(name.trim()))
                .toList();
    }
}
