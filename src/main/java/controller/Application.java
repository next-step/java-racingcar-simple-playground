package controller;

import domain.RacingGame;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(final String... args) {
        final String[] carNames = InputView.getCarNames();
        final int tryCount = InputView.getTryCount();

        final var racingGame = new RacingGame(carNames, tryCount);
        racingGame.race();
        
        ResultView.printWinners(racingGame.getWinners());
    }
}
