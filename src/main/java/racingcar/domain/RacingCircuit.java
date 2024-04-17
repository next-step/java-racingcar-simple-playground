package racingcar.domain;

import java.util.List;
import java.util.stream.IntStream;

public class RacingCircuit {

    private static final int LOWER_BOUND_RACE_TRY_COUNT = 1;

    private Cars cars;

    public void registerCars(final Cars cars) {
        this.cars = cars;
    }

    public List<Cars> startRace(final int raceTryCount) {
        validateRaceTryCount(raceTryCount);

        return IntStream.range(0, raceTryCount)
                .mapToObj(i -> moveCars())
                .toList();
    }

    private void validateRaceTryCount(final int raceTryCount) {
        if (raceTryCount < LOWER_BOUND_RACE_TRY_COUNT) {
            throw new IllegalArgumentException(String.format("레이스는 %d회 이상 진행되어야 합니다.", LOWER_BOUND_RACE_TRY_COUNT));
        }
    }

    private Cars moveCars() {
        return cars = cars.moveForward();
    }

    public Cars findWinners() {
        return cars.findWinners();
    }
}
