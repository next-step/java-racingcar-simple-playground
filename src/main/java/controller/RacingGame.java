package controller;

import domain.Winners;
import domain.car.Car;
import domain.car.CarNameParser;
import java.util.ArrayList;
import java.util.List;
import view.OutputView;

public class RacingGame {
    private final List<Car> cars;
    private final int tryCount;

    public RacingGame(String carNames, int tryCount) {
        this.cars = createCars(carNames);
        this.tryCount = tryCount;
    }

    private List<Car> createCars(String carNames) {
        List<String> parsedNames = CarNameParser.nameParse(carNames);
        List<Car> cars = new ArrayList<>();
        for (String name : parsedNames) {
            cars.add(Car.createDefaultCar(name));
        }
        return cars;
    }

    public void run() {
        for (int i = 0; i < tryCount; i++) {
            moveCars();
            OutputView.printCarStatuses(cars);
        }
        OutputView.printWinner(Winners.findWinnersNames(cars));
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }
}
