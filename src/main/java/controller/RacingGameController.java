package controller;

import domain.Cars;
import domain.CarsMapper;
import domain.NumberGenerateStrategy;
import domain.RacingGame;
import java.util.List;
import view.InputView;
import view.OutputView;

public class RacingGameController {
    private final NumberGenerateStrategy strategy;

    public RacingGameController(NumberGenerateStrategy strategy) {
        this.strategy = strategy;
    }

    public void run() {
        final List<String> carNames = InputView.readCarNames();
        final Cars cars = CarsMapper.mapByCarNames(strategy, carNames);
        final RacingGame racingGame = new RacingGame(cars);

        final int attemptNumber = InputView.readAttemptNumber();

        OutputView.printfResult();
        race(racingGame, attemptNumber);

        final Cars winningCars = racingGame.findWinningCars();
        OutputView.printResultOfWinner(winningCars);
    }

    private void race(final RacingGame racingGame, final int attemptNumber) {
        for (int i = 0; i < attemptNumber; i++) {
            racingGame.race();
            OutputView.printCarsInfo(racingGame.getCars());
        }
    }
}
