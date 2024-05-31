package controller;

import domain.RacingGame.NumberGenerator;
import domain.RacingGame.RacingGame;
import service.RacingGameService;

public class RacingGameController {

    private final RacingGameService racingGameService;
    private final NumberGenerator numberGenerator;

    public RacingGameController(NumberGenerator numberGenerator) {
        this.racingGameService = new RacingGameService();
        this.numberGenerator = numberGenerator;
    }

    public void gameStart() {
        final RacingGame racingGame = racingGameService.generateRacingGame(numberGenerator);
        final int tryCount = racingGameService.getTryCount();
        racingGameService.race(racingGame, tryCount);
        racingGameService.printWinner(racingGame);
    }


}
