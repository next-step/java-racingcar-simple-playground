package service;

import domain.RacingCarGame;
import util.RandomGenerator;
import view.InputView;
import view.OutputView;

public class RacingCarService {
    public void play(String[] names, int times) {
        RacingCarGame game= new RacingCarGame(names, times, new RandomGenerator());
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