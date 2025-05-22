import controller.RacingGame;
import view.InputView;

public class Application {
    public static void main(String[] args) {
        final String carNames = InputView.getCarNames();
        final int tryCount = InputView.getTryCount();
        final RacingGame racingGame = new RacingGame(carNames, tryCount);
        racingGame.run();
    }
}
