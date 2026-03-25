package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class RacingGameController {
    public void run() {
        String[] carNames = InputView.readCarNames();
        RacingGame racingGame = createRacingGame(carNames);

        int tryCount = InputView.readTryCount();
        OutputView.printResultHeader();
        playRounds(racingGame, tryCount);
        OutputView.printWinners(racingGame.getWinners());
    }

    private RacingGame createRacingGame(String[] carNames) {
        return new RacingGame(new Cars(createCars(carNames)), new RandomNumberGenerator());
    }

    private List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(String::trim)
                .map(Car::new)
                .toList();
    }

    private void playRounds(RacingGame racingGame, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racingGame.playRound();
            OutputView.printRoundResult(racingGame.getCars());
        }
    }
}
