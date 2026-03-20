package controller;

import model.Cars;
import model.CarsWinner;
import view.InputView;
import view.OutputView;


public class RacingController {
    public void run() {
        String[] carNames = InputView.getCarNames();
        int raceCount = InputView.getRaceCount();

        Cars cars = new Cars(carNames);
        CarsWinner carsWinner = new CarsWinner();

        OutputView.printResultMessage();
        RacingService racingService = new RacingService();
        racingService.startRace(cars, raceCount);

        OutputView.printWinners(carsWinner.findWinners(cars));
    }
}
