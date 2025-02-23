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
        InputView inputView = new InputView();
        String inputNames = inputView.getCarNames();
        int gameCount = inputView.getGameCount();

        String[] splitedInputNames = splitCarNames(inputNames);
        List<Car> cars = racingGameService.playRacingGame(splitedInputNames, gameCount);

        ResultView.printWinners(racingGameService.getWinners(cars));
    }

    public String[] splitCarNames(String names) {
        final String defaultNameDelimiter = ",";
        return names.split(defaultNameDelimiter);
    }
}
