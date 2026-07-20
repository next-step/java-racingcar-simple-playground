package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
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

    public void moveAll(MovingStrategy movingStrategy, NumberGenerator numberGenerator) {
        for (Car car : cars) {
            moveIfMovable(car, movingStrategy, numberGenerator);
        }
    }

    private void moveIfMovable(Car car, MovingStrategy movingStrategy, NumberGenerator numberGenerator) {
        if (movingStrategy.isMovable(numberGenerator.generate())) {
            car.move();
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
