import domain.RacingGame;
import view.InputView;
import view.ResultView;

public class RacingApplication {

    public static void main(String[] args) {
        final String[] carNames = InputView.getCarNames();
        final int tryCount = InputView.getTryCount();

        final RacingGame racingGame = new RacingGame(tryCount, carNames);
        racingGame.race();

        ResultView.printWinners(racingGame.getWinners());
    }
}
