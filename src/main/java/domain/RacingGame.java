package domain;

import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int RANDOM_BOUND = 10;
    private static final int FORWARD_STANDARD = 4;

    private final Random random = new Random();
    private final Cars cars;
    private final int raceAttemptCount;

    public RacingGame(List<String> carNames, int raceAttemptCount) {
        this.raceAttemptCount = raceAttemptCount;
        this.cars = new Cars(carNames);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getRaceAttemptCount() {
        return raceAttemptCount;
    }

    public void doRace() {
        for (int i = 0; i < raceAttemptCount; i++) {
            cars.moveCars(this::shouldMove);
        }
    }

    private boolean shouldMove() {
        return random.nextInt(RANDOM_BOUND) >= FORWARD_STANDARD;
    }

    public List<String> getWinnerCarNames() {
        return cars.getWinnerCarNames();
    }

}
