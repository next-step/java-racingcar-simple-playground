package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;

import java.util.List;

public class Application {
    public static void main(final String... args) {
        final List<String> carNames = InputView.getCarNames();
        final int tryCount = InputView.getTryCount();

        final RacingGame racingGame = new RacingGame(carNames.size(), tryCount);

        for (String carName : carNames) {
            racingGame.addCar(carName);
        }

        System.out.println("실행 결과");
        racingGame.race();

        InputView.closeScanner();
    }
}
