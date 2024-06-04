package controller;

import model.RacingGame;
import view.OutputView;

public class RacingGameController {

    private final RacingGame racingGame;

    public RacingGameController(final RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public static RacingGameController of(final String[] carNames, final int racingCount) {
        return new RacingGameController(RacingGame.of(carNames, racingCount));
    }

    public void race() {
        for (int i = 0; i < racingGame.getRacingCount(); i++) {
            racingGame.moveCars();
            OutputView.printRacing(racingGame.getCars());
        }

        OutputView.printResult(racingGame.getWinners());
    }

    public RacingGame getRacingGame() {
        return racingGame;
    }
}
