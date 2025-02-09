import domain.Game;
import view.InputView;
import view.ResultView;

public class Application {

    public static void main(final String... args) {
        final String carNames = InputView.inputCarNames();
        final int tryCount = InputView.inputTryCount();

        final Game game = new Game(carNames, tryCount);
        game.play();
        ResultView.outputResult(game);
    }
}
