package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.MoveResults;
import racingcar.generator.NumberGenerator;

public class Circuit {

    private final List<Car> cars = new ArrayList<>();
    private final NumberGenerator generator;

    public Circuit(final NumberGenerator generator) {
        this.generator = generator;
    }

    public void registerCars(final List<String> carNames) {
        cars.addAll(carNames.stream()
                .map(Car::new)
                .toList());
    }

    public List<MoveResults> startRace(final int raceTryCount) {
        return IntStream.range(0, raceTryCount)
                .mapToObj(i -> moveCars())
                .toList();
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
