package model;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private int tryCount;

    public RacingGame(List<String> carNames, int tryCount) {
        this.cars = new Cars(carNames);
        this.tryCount = tryCount;
    }

    public void playOneRound(NumberGenerator generator) {
        cars.moveAll(generator);
        tryCount--;
    }

    public boolean isEnd() {
        return tryCount <= 0;
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }

    public Cars getCars() {
        return cars;
    }
}
