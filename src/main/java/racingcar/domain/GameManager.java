package racingcar.domain;

import java.util.List;
import java.util.Random;

public class GameManager {

    private static final int RANDOM_BOUND = 10;
    private static final int MIN_VALUE_TO_MOVE = 4;

    private Cars cars;
    private final Random random;

    public GameManager(Random random, List<String> carNames) {
        this.random = random;
        this.cars = Cars.from(carNames);
    }

    public void raceOneRound() {
        cars.raceOneRound(random, RANDOM_BOUND, MIN_VALUE_TO_MOVE);
    }

    public List<Car> getCars() {
        return cars.asUnmodifiableList();
    }

    public List<Car> getWinCars() {
        return cars.winners();
    }
}
