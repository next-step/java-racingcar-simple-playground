package model;

import java.util.List;
import strategy.MoveStrategy;

public class RaceManager {
    private final TryCount tryCount;
    private final Cars cars;

    public RaceManager(final int tryCount, final String carNames) {
        this.tryCount = new TryCount(tryCount);
        this.cars = new Cars(carNames);
    }

    public void start(final MoveStrategy moveStrategy) {
        for (int i = 0; i < tryCount.value(); i++) {
            cars.move(moveStrategy);
        }
    }

    public List<Integer> getAllPositions() {
        return cars.getAllPositions();
    }


    public List<String> findWinnerNames() {
        return cars.findWinners().stream()
                .map(Car::getName)
                .toList();
    }
}
