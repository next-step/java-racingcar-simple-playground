package service;

import domain.Car;
import domain.Riding;
import util.CarsCreator;
import view.RacingProceedingView;

import java.util.List;

public class RacingGame {
    private final int executionsCount;
    private final WinnerCarsSelector winnerCarsSelector;
    private final ProceedingRacing proceedingRacing;
    private final List<Car> cars;

    public RacingGame(final List<String> carNames, final int executionsCount) {
        this.executionsCount = executionsCount;
        this.cars = createCars(carNames);
        this.winnerCarsSelector = new WinnerCarsSelector();
        this.proceedingRacing = new ProceedingRacing(new Riding());
    }

    public List<String> start() {
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
