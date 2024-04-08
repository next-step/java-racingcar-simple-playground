package domain;

import java.util.Comparator;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int getMaxDistance() {
        return cars.stream()
                .max(Comparator.comparing(Car::getDistance))
                .orElse(null)
                .getDistance();
    }

    public void race() {
        cars.forEach(Car::race);
    }
}
