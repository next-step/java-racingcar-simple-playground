package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void move(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    private int findMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = findMaxPosition();

        for (Car car : cars) {
            addWinner(car, maxPosition, winners);
        }

        return winners;
    }

    private void addWinner(Car car, int maxPosition, List<Car> winners) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }

    public Iterable<Car> iterateCars() {
        return List.copyOf(cars);
    }
}
