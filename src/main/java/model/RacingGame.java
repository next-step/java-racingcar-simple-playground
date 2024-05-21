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
        final List<Car> cars = Arrays.stream(carNames)
                .map(name -> new Car(name, new RandomMoveStrategy()))
                .toList();

        return new RacingGame(new Cars(cars), new RacingCount(count));
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
