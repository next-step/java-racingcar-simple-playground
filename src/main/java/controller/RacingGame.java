package controller;

import java.util.List;
import mapper.CarToProgressMapper;
import model.RaceManager;
import model.dto.CarProgress;
import view.OutputView;

public class RacingGame {
    private final RaceManager raceManager;

    public RacingGame(final RaceManager raceManager) {
        this.raceManager = raceManager;
    }

    public void run() {
        OutputView.printResultHeader();

        for (int i = 0; i < raceManager.getTryCount(); i++) {
            raceManager.moveOnce();
            List<CarProgress> progresses = CarToProgressMapper.toProgress(raceManager.getRaceCars());
            OutputView.printCarProgress(progresses);
        }

        OutputView.printWinners(raceManager.findWinnerNames());
    }
}
