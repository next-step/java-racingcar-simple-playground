package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    public void move(MovingStrategy movingStrategy, NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(movingStrategy, numberGenerator.generate());
        }
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        return findCarsAt(maxPosition);
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<Car> findCarsAt(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .toList();
    }
}
