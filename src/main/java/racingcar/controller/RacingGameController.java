package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public void run() {
        String[] carNames = InputView.readCarNames();
        RacingGame racingGame = createRacingGame(carNames);

        int tryCount = InputView.readTryCount();
        OutputView.printResultHeader();
        playRounds(racingGame, tryCount);
        OutputView.printWinners(racingGame.getWinnerNames());
    }

    private RacingGame createRacingGame(String[] carNames) {
        return new RacingGame(new Cars(Cars.createCars(carNames)), new RandomNumberGenerator());
    }

    private void playRounds(RacingGame racingGame, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racingGame.playRound();
            OutputView.printRoundResult(racingGame.getCars());
        }
    }
}
