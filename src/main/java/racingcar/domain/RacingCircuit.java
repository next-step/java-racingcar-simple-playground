package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import racingcar.generator.NumberGenerator;

public class RacingCircuit {

    private final List<Car> cars = new ArrayList<>();
    private final NumberGenerator generator;

    public RacingCircuit(final NumberGenerator generator) {
        this.generator = generator;
    }

    public void registerCars(final List<String> carNames) {
        cars.addAll(carNames.stream()
                .filter(Objects::nonNull)
                .map(Car::new)
                .toList());
    }

    public List<MoveResults> startRace(final int raceTryCount) {
        validateRaceTryCount(raceTryCount);

        return IntStream.range(0, raceTryCount)
                .mapToObj(i -> moveCars())
                .toList();
    }

    private void validateRaceTryCount(final int raceTryCount) {
        if (raceTryCount <= 0) {
            throw new IllegalArgumentException("레이스는 1회 이상 진행되어야 합니다.");
        }
    }

    private MoveResults moveCars() {
        for (Car car : cars) {
            car.moveForward(generator.generateNumber());
        }

        return MoveResults.create(cars);
    }

    public List<String> findWinners() {
        int winnerPosition = findWinnerPosition();

        return cars.stream()
                .filter(car -> car.isSamePosition(winnerPosition))
                .map(Car::getName)
                .toList();
    }

    private int findWinnerPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
