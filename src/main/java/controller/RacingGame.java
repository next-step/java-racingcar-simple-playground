package controller;

import model.RaceManager;
import strategy.RandomMoveStrategy;
import view.OutputView;

public class RacingGame {
    private final RaceManager raceManager;
    private final RandomMoveStrategy randomMoveStrategy;

    public RacingGame(final RaceManager raceManager, final RandomMoveStrategy randomMoveStrategy) {
        this.raceManager = raceManager;
        this.randomMoveStrategy = randomMoveStrategy;
    }

    public void run() {
        OutputView.printResultHeader();

        for (int i = 0; i < raceManager.getTryCount(); i++) {
            raceManager.moveOnce(randomMoveStrategy);
            OutputView.printCarStatus(raceManager.getRaceCars());
        }

        OutputView.printWinners(raceManager.findWinnerNames());
    }
}
