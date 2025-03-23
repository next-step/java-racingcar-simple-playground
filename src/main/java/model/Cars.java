package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    private Cars(List<Car> cars, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
    }

    public static Cars create(List<String> carNames, NumberGenerator numberGenerator) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return new Cars(cars, numberGenerator);
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public int findLeadingPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    public Cars getLeadingCars() {
        int leadingPosition = findLeadingPosition();
        List<Car> leadingCars = cars.stream().filter(car -> car.hasSamePosition(leadingPosition)).toList();
        return new Cars(leadingCars, numberGenerator);
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
