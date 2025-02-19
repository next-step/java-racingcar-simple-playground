package controller;

import domain.RacingGame;
import view.InputView;
import view.ResultView;
import java.util.List;

public class RacingGameController {

    private final ResultView resultView = new ResultView();
    private RacingGame racingGame;

    public void run() {
        initialize();
        playGame();
        printResults();
    }

    private void initialize() {
        List<String> carNames = InputView.getCarNames();
        int raceAttemptCount = InputView.getTryCount();
        racingGame = new RacingGame(carNames, raceAttemptCount);
    }

    private void playGame() {
        for (int i = 0; i < racingGame.getRaceAttemptCount(); i++) {
            racingGame.doRace();
            resultView.printRaceResult(racingGame.getCars());
        }
    }

    private void printResults() {
        resultView.printWinnerCarNames(racingGame.getWinnerCarNames());
    }

}
