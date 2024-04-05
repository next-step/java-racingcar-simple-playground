package domain;

import java.util.List;

public class RacingGame {

    private final Cars cars;

    public RacingGame(final Cars cars) {
        this.cars = cars;
    }

    public void race(final int attemptNumber) {
        for (int i = 0; i < attemptNumber; i++) {
            cars.move();
        }
    }

    public List<Car> findWinningCars() {
        final int maxPosition = cars.findMaxPosition();
        return cars.findCarsWithPosition(maxPosition);
    }
}
