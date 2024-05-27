package service;

import domain.RacingCarGame;
import view.InputView;
import view.OutputView;

public class RacingCarService {
    public void play() {
        String[] names = InputView.getCarNames();
        int times = InputView.getTimes();

        RacingCarGame game= new RacingCarGame(names, times);
        race(game);
        OutputView.printFinalResult(game.getWinners());
    }

    private void race(RacingCarGame game) {
        for(int i = 0; i < game.getTimes(); i++) {
            game.playTurn();
            OutputView.printEachRace(game.getRacingCars());
        }
    }
}
