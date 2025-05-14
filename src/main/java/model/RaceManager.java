package model;

import java.util.List;
import strategy.MoveStrategy;

public class RaceManager {
    private final Cars cars;
    private final TryCount tryCount;

    public RaceManager(final List<String> carNames, final int tryCount, final MoveStrategy moveStrategy) {
        this.cars = new Cars(carNames, moveStrategy);
        this.tryCount = new TryCount(tryCount);
    }

    public Cars getRaceCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount.value();
    }

    public void moveOnce() {
        cars.move();
    }

    public List<String> findWinnerNames() {
        return cars.findWinners();
    }
}
