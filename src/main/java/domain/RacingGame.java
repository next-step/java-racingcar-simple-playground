package domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(final Cars cars) {
        this.cars = cars;
    }

    public void race() {
        cars.move();
    }

    public Cars findWinningCars() {
        final int maxPosition = cars.findMaxPosition();
        final List<Car> winningCars = cars.findCarsByPosition(maxPosition);
        return new Cars(winningCars);
    }

    public Cars getCars() {
        return cars;
    }
}
