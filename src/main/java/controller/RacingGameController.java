package controller;

import domain.RacingGame;
import view.InputView;
import view.ResultView;

import java.util.List;

public class RacingGameController {

    public void run() {
        List<String> carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        RacingGame racingGame = new RacingGame(carNames, tryCount);

        ResultView.printHeader();
        for (int i = 0; i < racingGame.getTryCount(); i++) {
            racingGame.playRound();
            ResultView.printCars(racingGame.getCars());
        }
        ResultView.printWinners(racingGame.getWinners());
    }
}
