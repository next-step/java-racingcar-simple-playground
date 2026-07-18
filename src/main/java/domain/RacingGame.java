package domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int tryCount;
    private final NumberGenerator numberGenerator;
    private final MovingStrategy movingStrategy;

    public RacingGame(List<String> carNames, int tryCount) { // 기본 레이싱 게임
        this(carNames, tryCount, new RandomNumberGenerator(), new NumberMovingStrategy());
    }

    public RacingGame(List<String> carNames, int tryCount, NumberGenerator numberGenerator) {
        this(carNames, tryCount, numberGenerator, new NumberMovingStrategy());
    }

    public RacingGame(List<String> carNames, int tryCount, MovingStrategy movingStrategy) {
        this(carNames, tryCount, new RandomNumberGenerator(), movingStrategy);
    }

    public RacingGame(List<String> carNames, int tryCount, NumberGenerator numberGenerator, MovingStrategy movingStrategy) {
        this(Cars.from(carNames), tryCount, numberGenerator, movingStrategy);
    }

    private RacingGame(Cars cars, int tryCount, NumberGenerator numberGenerator, MovingStrategy movingStrategy) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.numberGenerator = numberGenerator;
        this.movingStrategy = movingStrategy;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void playRound() {
        cars.move(movingStrategy, numberGenerator);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }
}
