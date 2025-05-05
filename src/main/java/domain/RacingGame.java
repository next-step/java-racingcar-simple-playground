package domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final NumberGenerator numberGenerator;

    public RacingGame(Cars cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void playOneRound() {
        cars.attemptToMoveAll(numberGenerator);
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
