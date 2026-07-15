import view.InputView;
import view.ResultView;
import domain.RacingGame;

import java.util.List;

public class Application {
    public static void main(final String... args) {
        final List<String> carNames = InputView.getCarNames();
        final int tryCount = InputView.getTryCount();

        final RacingGame racingGame = new RacingGame(carNames, tryCount);

        ResultView.printHeader();
        for (int i = 0; i < racingGame.getTryCount(); i++) {
            racingGame.playRound();
            ResultView.printCars(racingGame.getCars());
        }
        ResultView.printWinners(racingGame.getWinners());
    }
}
