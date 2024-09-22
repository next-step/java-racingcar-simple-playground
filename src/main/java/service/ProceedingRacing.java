package service;

import domain.Car;
import view.RacingProceedingView;

import java.util.List;

public class ProceedingRacing {

    public void startRacing(final List<Car> cars, final int executionsCount) {
        RacingProceedingView.printProceedingRacingResult(cars);
        for (int i = 0; i < executionsCount; i++) {
            racingCars(cars);
            RacingProceedingView.printProceedingRacingResult(cars);
        }
    }

    private void racingCars(final List<Car> cars) {
        for (Car currentCar : cars) {
            currentCar.ride();
        }
    }
}
