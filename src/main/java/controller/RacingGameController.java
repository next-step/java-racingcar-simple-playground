package controller;

import domain.Car;
import global.InputView;
import global.ResultView;
import service.RacingGameService;

import java.util.List;

public class RacingGameController {
    RacingGameService racingGameService = new RacingGameService();
    public void racingGame() {
        try (InputView inputView = new InputView()) {
            String[] inputNames = inputView.getCarNames();
            int gameCount = inputView.getGameCount();

            printEmptyLine();

            List<Car> cars = racingGameService.playRacingGame(inputNames, gameCount);

            ResultView.printWinners(racingGameService.getWinners(cars));
        }
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
