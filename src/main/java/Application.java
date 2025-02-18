import domain.Racing;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(final String... args) {
        final String[] carNames = InputView.getCarNames();
        final int tryCount = InputView.getTryCount();

        final Racing racingGame = new Racing(carNames, tryCount);
        racingGame.race();
        ResultView.printMoving(racingGame);

        ResultView.printWinners(racingGame.getWinners());
    }
}
