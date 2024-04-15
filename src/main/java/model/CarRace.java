package model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarRace {
    private List<Car> cars;
    private int attempt;

    public CarRace(List<Car> cars, int attempt) {
        this.cars = cars;
        this.attempt = attempt;
    }

    public void raceStart() {
        Random random = new Random();
        for (int i = 0; i < attempt; i++) {
            for (Car car : cars) {
                car.move(random.nextInt(10));
            }
            view.GameView.printRaceResults(cars);
        }
    }

    public List<Car> findWinner() {
        int furthestDistance = cars.stream()
            .mapToInt(Car::getPosition)
            .max().orElse(0);

        return cars.stream()
            .filter(car -> car.getPosition() == furthestDistance)
            .collect(Collectors.toList());
    }
}
