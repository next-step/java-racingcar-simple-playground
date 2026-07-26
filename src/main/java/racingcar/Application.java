package racingcar;

import racingcar.domain.RacingCars;
import racingcar.domain.RacingGameWinner;
import racingcar.domain.RacingLap;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;

import java.util.List;
import racingcar.view.ResultView;

public class Application {
    public static void main(final String... args) {
        final List<String> carNames = InputView.setCarNames();
        RacingCars racingCars = new RacingCars(carNames);

        final int lapCount = InputView.setLapCount();
        RacingLap racingLap = new RacingLap(lapCount);

        RacingGame racingGame = new RacingGame(racingCars.getCarsList(), racingLap.getLapCount());

        for (int i = 0; i < racingLap.getLapCount(); i++) {
            ResultView.printLapResult(racingGame.startLap());
        }

        RacingGameWinner racingGameWinner = new RacingGameWinner();
        ResultView.printWinners(racingGameWinner.selectWinners(racingGame));

        System.out.println("실행 결과");

        InputView.closeScanner();
    }
}
