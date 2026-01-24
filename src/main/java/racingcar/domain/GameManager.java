package racingcar.domain;

import java.util.List;
import java.util.Random;

public class GameManager {

    private final Cars cars;
    private final MoveStrategy moveStrategy;

    public GameManager(List<String> carNames, MoveStrategy moveStrategy) {
        this.cars = Cars.from(carNames);
        this.moveStrategy = moveStrategy;
    }

    public void raceOneRound() {
        cars.raceOneRound(moveStrategy);
    }

    public List<Car> getCars() {
        return cars.asUnmodifiableList();
    }

    public List<Car> getWinCars() {
        return cars.winners();
    }
}
