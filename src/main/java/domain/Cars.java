package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(List<String> carNames, NumberGenerator numberGenerator) {
        List<Car> newCars = new ArrayList<Car>();
        for (String carName : carNames) {
            newCars.add(new Car(carName, numberGenerator));
        }
        return new Cars(newCars);
    }

    public static Cars of(List<Car> cars) {
        return new Cars(new ArrayList<>(cars));
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    public Cars findCarsHasSamePosition(int position) {
        List<Car> carsHasSamePosition = cars.stream()
                .filter(car -> car.hasSamePosition(position))
                .collect(Collectors.toList());

        return new Cars(carsHasSamePosition);
    }

    public List<Car> getCars() {
        return cars;
    }

}
