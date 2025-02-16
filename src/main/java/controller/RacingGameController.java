package controller;

import domain.RacingGame;

public class RacingGameController {
    public void run() {
        RacingGame racingGame = new RacingGame();
        racingGame.initializeRace();
        racingGame.startRace();
    }

}
