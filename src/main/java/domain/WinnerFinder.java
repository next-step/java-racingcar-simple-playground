package domain;

import java.util.List;

public class WinnerFinder {

    public List<String> findWinners(List<Car> cars) {
        int maxLocation = findMaxLocation(cars);

        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .toList();
    }

    private int findMaxLocation(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }
}
