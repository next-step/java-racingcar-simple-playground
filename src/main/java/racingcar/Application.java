package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameWinner;
import racingcar.domain.RacingLap;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(final String... args) {
        final List<String> carNames = InputView.setCarNames();
        RacingCars racingCars = new RacingCars(carNames);

        final int lapCount = InputView.setLapCount();
        RacingLap racingLap = new RacingLap(lapCount);

        final List<Car> validatedCarNames = racingCars.getCarsList();
        final int validatedLapCount = racingLap.getLapCount();
        RacingGame racingGame = new RacingGame(validatedCarNames, validatedLapCount);

        System.out.println("실행 결과");
        for (int i = 0; i < racingLap.getLapCount(); i++) {
            ResultView.printLapResult(racingGame.startLap());
        }

        RacingGameWinner racingGameWinner = new RacingGameWinner();
        ResultView.printWinners(racingGameWinner.selectWinners(racingGame));

        InputView.closeScanner();
    }
}
