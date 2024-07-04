package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    public static void main(final String... args) {
        final var carNames = InputView.inputCarNames();
        final var tryCount = InputView.inputTryCount();

        final var racingGame = RacingGame.create(carNames, tryCount);
        racingGame.race();

        ResultView.printWinner(racingGame.getWinners());
    }
}
