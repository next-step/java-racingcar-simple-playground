package controller;

import domain.Car;
import domain.Cars;
import domain.MoveStrategy;
import view.OutputView;

import java.util.List;

public class RacingGameController {
    private final Cars cars;
    private final int tries;

    public RacingGameController(final List<String> names, final int tries, final MoveStrategy strategy) {
        this.cars = new Cars(names, strategy);
        this.tries = tries;
    }

    public void start() {
        for (int i = 0; i < tries; i++) {
            moveCars();
            OutputView.printStatus(cars.getCars());
        }
        OutputView.printWinners(getWinners());
    }

    private void moveCars() {
        cars.getCars().forEach(Car::move);
    }

    private List<Car> getWinners() {
        int maxPos = cars.getCars().stream().mapToInt(Car::getPos).max().orElse(0);

        return cars.getCars().stream().filter(car -> car.getPos() == maxPos).toList();
    }
}