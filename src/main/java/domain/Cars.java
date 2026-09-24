package domain;

import java.util.Collections;
import java.util.List;

public class Cars {
    private static final int INITIAL_POSITION = 0;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCars(String value) {
        String[] names = value.split(",");
        for (String name : names) {
            cars.add(new Car(name, INITIAL_POSITION));
        }
    }

    public boolean isEmpty() {
        return cars.isEmpty();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
