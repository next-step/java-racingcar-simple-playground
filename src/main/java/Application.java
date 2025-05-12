import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        final var carNames = InputView.readCarNames();
        final var tryCount = InputView.readTryCount();

        final var racingGame = new RacingGame(carNames, tryCount);
        racingGame.race();

        ResultView.printWinners(racingGame.getWinners());
    }
}
