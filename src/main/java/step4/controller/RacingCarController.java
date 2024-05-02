package step4.controller;

import step4.domain.Car;
import step4.domain.RacingGame;
import step4.domain.FindWinners;
import step4.view.OutputView;

import java.util.List;

public class RacingCarController {

    private final RacingGame racingGame;

    public RacingCarController(String carNames, int tryNo) {
        this.racingGame = new RacingGame(carNames, tryNo);
    }

    public void startRace() {
        OutputView.printRaceStartMessage();
        processRace();
    }

    private void processRace() {
        while (racingGame.racing()) {
            racingGame.race();
            showRaceScore(racingGame.getCars());
        }
    }

    private void showRaceScore(List<Car> cars) {
        OutputView.printRaceScore(cars);
    }

    public List<String> getWinners() {
        return FindWinners.findWinners(racingGame.getCars());
    }

    public RacingGame getRacingGame() {
        return racingGame;
    }
}
