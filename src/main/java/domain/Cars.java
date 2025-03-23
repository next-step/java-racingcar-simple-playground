package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(name -> new Car(name.trim()))
                .collect(Collectors.toList());
    }

    public void move(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    private static int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(0);
    }

    public static List<Car> getWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(c -> c.getPosition() == maxPosition)
                .toList();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
