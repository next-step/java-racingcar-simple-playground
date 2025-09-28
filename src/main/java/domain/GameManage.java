package domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameManage {
    private final Cars cars;

    public GameManage(Cars cars) {
        this.cars = cars;
    }

    public void raceOneRound() {
        for (Car car : cars.getCars()) {
            car.moveCar();
        }
    }

    private Map<Integer, List<Car>> groupPosition() {
        return cars.getCars().stream().collect(Collectors.groupingBy(Car::getCarPosition));
    }

    public Winners createWinners() {
        Map<Integer, List<Car>> carsByPosition = groupPosition();

        List<Car> winnersGroup = carsByPosition.entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList());

        List<String> winnerNames = winnersGroup.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());

        return Winners.of(winnerNames);
    }
}
