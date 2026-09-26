package domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RandomNumber randomNumber;
    private final int tryCount;

    public RacingGame(Cars cars, RandomNumber randomNumber, int tryCount) {
        this.cars = cars;
        this.randomNumber = randomNumber;
        this.tryCount = tryCount;
    }

    public void carRaceOnce() {
        cars.move(randomNumber);
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<Car> findWinners() {
        int maxPosition = cars.getMaxPosition();
        return cars.carsAt(maxPosition);
    }
}
