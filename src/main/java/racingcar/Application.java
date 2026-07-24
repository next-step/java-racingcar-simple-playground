package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameSetting;
import racingcar.view.InputView;

import java.util.List;

public class Application {
    public static void main(final String... args) {
        final List<String> carNames = InputView.setCarNames();
        final RacingGameSetting racingGameSetting = new RacingGameSetting(carNames, InputView.setTryCount());
        final RacingGame racingGame = new RacingGame(racingGameSetting);

        System.out.println("실행 결과");

        racingGame.race();

        InputView.closeScanner();
    }
}
