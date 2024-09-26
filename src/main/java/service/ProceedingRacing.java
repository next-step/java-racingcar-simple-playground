package service;

import domain.Car;
import domain.Riding;
import util.RandomValueCreator;
import view.RacingProceedingView;

import java.util.List;

public class ProceedingRacing {

    Riding riding;

    public ProceedingRacing(Riding riding) {
        this.riding = riding;
    }

    public void startRacing(final List<Car> cars, final int executionsCount) {
        RacingProceedingView.printProceedingRacingResult(cars);
        for (int i = 0; i < executionsCount; i++) {
            racingCars(cars);
            RacingProceedingView.printProceedingRacingResult(cars);
        }
    }

    private void racingCars(final List<Car> cars) {
        for (Car currentCar : cars) {
            riding.ride(currentCar, RandomValueCreator.createRandomValue());
        }
    }
}
