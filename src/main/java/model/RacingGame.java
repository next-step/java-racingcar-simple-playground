package model;

import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final RacingCount count;

    public RacingGame(final Cars cars, final RacingCount count) {
        this.cars = cars;
        this.count = count;
    }

    public static RacingGame of (final String[] carNames, final int count) {
        return new RacingGame(Cars.from(carNames), new RacingCount(count));
    }

    public void moveCars() {
        cars.move();
    }

    public List<Car> getWinners() {
        final int maxPosition = cars.getMaxPosition();
        return cars.getMaxMoveCars(maxPosition);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getRacingCount() {
        return count.getValue();
    }
}
