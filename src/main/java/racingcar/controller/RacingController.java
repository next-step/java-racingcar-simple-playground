package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.vo.Name;
import racingcar.domain.vo.Repetition;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;
import racingcar.util.RandomNumberGenerator;

import java.util.List;

public class RacingController {

    private final RandomNumberGenerator randomNumberGenerator;

    public RacingController(final RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void playGame() {
        final Repetition repetition = initializeRoundCount();
        final Cars cars = initializeCars();

        final RacingGame game = new RacingGame(cars, randomNumberGenerator);

        executeGame(game, repetition);

        displayWinners(game);
    }

    private Repetition initializeRoundCount() {
        return new Repetition(InputView.inputRacingCount());
    }

    private Cars initializeCars() {
        return createCars(InputView.inputCarNames());
    }

    private void executeGame(final RacingGame game, final Repetition repetition) {
        OutputView.printGameStart();

        for (int i = 0; i < repetition.value(); i++) {
            game.moveCars();
            OutputView.printRoundResult(game.getCars());
        }
    }

    private static void displayWinners(RacingGame game) {
        OutputView.printWinners(game.getCars());
    }

    private Cars createCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(name -> new Car(new Name(name)))
                .toList());
    }
}
