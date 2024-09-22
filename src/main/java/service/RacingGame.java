package service;

import domain.Car;
import util.CarsCreator;
import view.RacingProceedingView;

import java.util.List;

public class RacingGame {

    private final List<String> carNames;
    private final int executionsCount;
    private final WinnerCarsSelector winnerCarsSelector = new WinnerCarsSelector();
    private final ProceedingRacing proceedingRacing = new ProceedingRacing();

    public RacingGame(final List<String> carNames, final int executionsCount) {
        this.carNames = carNames;
        this.executionsCount = executionsCount;
    }

    public List<Car> start() {
        List<Car> cars = createCars(carNames);
        RacingProceedingView.printTryingResult();
        startRacing(cars, executionsCount);
        return winnerCarsSelector.selectWinnerCars(cars);
    }

    private List<Car> createCars(List<String> carNames) {
        return CarsCreator.createCars(carNames);
    }

    private void startRacing(final List<Car> cars, final int executionsCount) {
        proceedingRacing.startRacing(cars, executionsCount);
    }
}
