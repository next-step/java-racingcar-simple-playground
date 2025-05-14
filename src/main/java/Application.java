import view.InputView;
import view.ResultView;
import domain.RacingGame;

public class Application {
    public static void main(final String... args) {
        final var carName = InputView.getCarName();
        final var count = InputView.getCount();

        final var racingGame = new RacingGame(carName, count);
        racingGame.race();

        ResultView.printWinner(racingGame.getWinner());
    }
}