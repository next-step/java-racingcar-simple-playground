package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<String> names, final MoveStrategy strategy) {
        this.cars = names.stream()
                .map(name -> new Car(name, strategy))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}