package model;

import java.util.List;
import strategy.MoveStrategy;

public class RaceManager {
    private final Cars cars;
    private final TryCount tryCount;

    public RaceManager(final List<String> carNames, final int tryCount) {
        this.cars = new Cars(carNames);
        this.tryCount = new TryCount(tryCount);
    }

    public Cars getRaceCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount.value();
    }

    public void moveOnce(final MoveStrategy moveStrategy) {
        cars.move(moveStrategy);
    }

    public List<String> findWinnerNames() {
        return cars.findWinners();
    }
}
