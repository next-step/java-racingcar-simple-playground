package domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int tryCount;
    private final NumberGenerator numberGenerator;
    private final MovingStrategy movingStrategy;

    public RacingGame(List<String> carNames, int tryCount, NumberGenerator numberGenerator, MovingStrategy movingStrategy) {
        this.cars = Cars.from(carNames);
        this.tryCount = tryCount;
        this.numberGenerator = numberGenerator;
        this.movingStrategy = movingStrategy;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void playRound() {
        cars.moveAll(movingStrategy, numberGenerator);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }
}
