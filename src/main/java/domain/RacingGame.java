package domain;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class RacingGame {
    private static final int RANDOM_BOUND = 10;
    private final Cars cars;
    private final int raceAttemptCount;
    private final Supplier<Integer> randomSupplier;

    public RacingGame(List<String> carNames, int raceAttemptCount, Supplier<Integer> randomSupplier) {
        this.raceAttemptCount = raceAttemptCount;
        this.cars = new Cars(carNames);
        this.randomSupplier = randomSupplier;
    }

    public RacingGame(List<String> carNames, int raceAttemptCount) {
        this(carNames, raceAttemptCount, () -> new Random().nextInt(RANDOM_BOUND));
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getRaceAttemptCount() {
        return raceAttemptCount;
    }

    public void doRace() {
        for (int i = 0; i < raceAttemptCount; i++) {
            cars.moveCars(() -> randomSupplier.get() >= 4);
        }
    }

    public List<String> getWinnerCarNames() {
        return cars.getWinnerCarNames();
    }

}
