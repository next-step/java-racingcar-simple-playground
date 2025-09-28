package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    private Cars() {
        this.cars = new ArrayList<>();
    }

    public static Cars createCars(List<String> carNames) {
        Cars cars = new Cars();
        Set<String> existingNames = new HashSet<>();
        for (String name : carNames) {
            String trimmed = name.trim();
            if (existingNames.contains(trimmed)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다: " + name);
            }
            existingNames.add(trimmed);
            CarName nameObj = new CarName(trimmed);
            cars.addCar(Car.createCarByCarName(nameObj));
        }
        return cars;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }
}
