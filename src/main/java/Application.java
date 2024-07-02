import domain.RacingGame;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(final String... args) {
        final String carNames = InputView.getCarNames();
        final int tryCount = InputView.getTryCount();

        RacingGame race = new RacingGame();
        race.inputCarList(carNames);
        race.startRace(tryCount);

        ResultView.printWinners(race.getWinners());
    }
}
