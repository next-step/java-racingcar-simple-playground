package controller;

import model.RaceManager;
import model.RaceRecorder;
import view.OutputView;

public class RacingGame {
    private final RaceManager raceManager;
    private final RaceRecorder raceRecorder;

    public RacingGame(final RaceManager raceManager) {
        this.raceManager = raceManager;
        this.raceRecorder = new RaceRecorder();
    }

    public void run() {
        OutputView.printResultHeader();

        for (int i = 0; i < raceManager.getTryCount(); i++) {
            raceManager.moveOnce();
            raceRecorder.record(raceManager.getRaceCars());
        }

        OutputView.printAllRaceRounds(raceRecorder);
        OutputView.printWinners(raceManager.findWinnerNames());
    }
}
