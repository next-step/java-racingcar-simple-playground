package controller;

import domain.Car;
import view.InputView;
import view.ResultView;
import service.RacingGameService;

import java.util.List;

public class RacingGameController {
    private final RacingGameService racingGameService;

    public RacingGameController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void racingGame() {
        try (InputView inputView = new InputView()) {
            String[] inputNames = inputView.getCarNames();
            int gameCount = inputView.getGameCount();

            List<Car> cars = racingGameService.playRacingGame(inputNames, gameCount);

            ResultView.printWinners(racingGameService.getWinners(cars));
        }
    }
}
