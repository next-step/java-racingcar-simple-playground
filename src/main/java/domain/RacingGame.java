package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private final int attemptCount;
    private final NumberGenerator numberGenerator;
    private final WinnerFinder winnerFinder;

    public RacingGame(
            List<String> carNames,
            int attemptCount,
            NumberGenerator numberGenerator
    ) {
        this.cars = createCars(carNames);
        this.attemptCount = attemptCount;
        this.numberGenerator = numberGenerator;
        this.winnerFinder = new WinnerFinder();
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public List<List<Car>> race() {
        List<List<Car>> raceResults = new ArrayList<>();

        for (int count = 0; count < attemptCount; count++) {
            moveCars();
            raceResults.add(copyCars());
        }

        return raceResults;
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    private List<Car> copyCars() {
        List<Car> copiedCars = new ArrayList<>();

        for (Car car : cars) {
            copiedCars.add(car.copy());
        }

        return copiedCars;
    }

    public List<String> getWinners() {
        return winnerFinder.findWinners(cars);
    }
}