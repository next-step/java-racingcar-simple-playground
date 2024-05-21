import model.RacingGame;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        final String[] carNames = InputView.readCarNames();
        final int racingCount = InputView.readRacingCount();
        final RacingGame racingGame = RacingGame.of(carNames, racingCount);

        race(racingGame);
        OutputView.printResult(racingGame.getWinners());
    }

    private static void race(final RacingGame racingGame) {
        for (int i = 0; i < racingGame.getRacingCount(); i++) {
            racingGame.moveCars();
            OutputView.printRacing(racingGame.getCars());
        }
    }
}
