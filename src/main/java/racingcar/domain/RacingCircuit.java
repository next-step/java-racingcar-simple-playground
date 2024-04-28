package racingcar.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RacingCircuit {

    private static final int INIT_ROUND = 0;
    private static final int LOWER_BOUND_RACE_TRY_COUNT = 1;

    private final Map<Integer, Cars> records = new HashMap<>();
    private final AtomicInteger roundCounter = new AtomicInteger(1);

    private final Cars registerCars;
    private final int raceTryCount;

    public RacingCircuit(final Cars registerCars, final int raceTryCount) {
        validateRaceTryCount(raceTryCount);
        this.registerCars = registerCars;
        this.raceTryCount = raceTryCount;
    }

    private void validateRaceTryCount(final int raceTryCount) {
        if (raceTryCount < LOWER_BOUND_RACE_TRY_COUNT) {
            throw new IllegalArgumentException(String.format("레이스는 %d회 이상 진행되어야 합니다.", LOWER_BOUND_RACE_TRY_COUNT));
        }
    }

    public Map<Integer, Cars> startRace() {
        records.put(INIT_ROUND, registerCars);
        moveCars();
        records.remove(INIT_ROUND);

        return Collections.unmodifiableMap(records);
    }

    private void moveCars() {
        for (int count = 0; count < raceTryCount; count++) {
            Cars previousRoundCars = findPreviousRoundCars();
            Cars currentRoundCars = previousRoundCars.moveForward();
            records.put(roundCounter.getAndIncrement(), currentRoundCars);
        }
    }

    private Cars findPreviousRoundCars() {
        int previousRound = roundCounter.get() - 1;

        return records.get(previousRound);
    }

    public Cars findWinners() {
        return records.get(raceTryCount)
                .findWinners();
    }
}
