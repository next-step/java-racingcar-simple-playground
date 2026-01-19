package domain;

import java.util.ArrayList;
import java.util.List;

public final class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public void moveAll(RandomNumberGenerator generator) {
        for (Car car : cars) {
            car.move(generator);
        }
    }

    public List<String> winnerNames() {
        int max = maxPosition();
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.position() == max) {
                winners.add(car.name());
            }
        }
        return winners;
    }

    private int maxPosition() {
        int max = 0;
        for (Car car : cars) {
            if (car.position() > max) {
                max = car.position();
            }
        }
        return max;
    }

    public List<Car> asList() {
        return cars;
    }
}