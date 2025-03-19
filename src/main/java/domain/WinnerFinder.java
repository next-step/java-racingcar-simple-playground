package domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerFinder {

    List<Car> winners = new ArrayList<>();

    public List<Car> findWinner(List<Car> cars) {
        winners.clear();
        int maxDistance = getMaxDistance(cars);

        for (Car car : cars) {
            addIfWinner(car, maxDistance);
        }

        return winners;
    }

    private void addIfWinner(Car car, int maxDistance) {
        if (car.getDistance() == maxDistance) {
            winners.add(car);
        }
    }

    private int getMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}
