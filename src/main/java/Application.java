import domain.Racing;
import view.InputView;
import view.ResultView;

public class Application
{
    public static void main(final String... args)
    {
        final var carNames = InputView.getCarNames();
        final var tryCount = InputView.getTryCount();

        final var racingGame = new Racing(carNames, tryCount);
        racingGame.race();

        ResultView.printWinners(racingGame.getWinners());
    }
}
