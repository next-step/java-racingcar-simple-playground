package domain;

import java.util.List;

public class CarRace {

    private final List<Car> cars;

    public CarRace(final List<Car> cars) {
        this.cars = cars;
    }

    public void raceOneLap() {
        for (Car car : cars) {
            car.moveOrStop();
        }
    }

    public List<String> selectWinners(){
        int max = 0;
        for (final Car car : cars) {
            max = Math.max(car.getDistance(), max);
        }
        final int finalMax = max;
        return cars.stream()
                .filter(car -> car.getDistance() == finalMax)
                .map(Car::getName)
                .toList();
    }

}