package racingcar.domain;

import java.util.List;

import racingcar.util.RandomGenerator;
import racingcar.view.OutputView;

public class RacingGame {
    private final List<Car> cars;
    private final RandomGenerator random;

    public RacingGame(List<Car> cars, RandomGenerator random) {
        this.cars = cars;
        this.random = random;
    }

    public List<Car> getWinners() {
        int max = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

        return cars.stream()
            .filter(car -> car.getPosition() == max)
            .toList();
    }

    public void move() {
        for (Car car : cars) {
            car.move(random);
        }
    }

    public void start(int round) {
        OutputView.printInit();
        for (int i = 0; i < round; i++) {
            move();
            OutputView.printMovement(cars);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
