import domain.Game;
import util.RandomNumberProvider;
import view.InputView;
import view.ResultView;

public class Application {

    public static void main(final String... args) {
        final String carNames = InputView.inputCarNames();
        final int tryCount = InputView.inputTryCount();

        final Game game = new Game(carNames, tryCount, new RandomNumberProvider());
        game.play();

        ResultView.outputResult(game);
    }
}
