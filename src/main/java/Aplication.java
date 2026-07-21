import view.InputView;
import view.ResultView;
import domain.RacingGame;

public class Aplication {
    public static void main(String[] args) {
        final String[] carNames = InputView.getCarNames();
        final int tryCount = InputView.getTryCount();
        final RacingGame racingGame = new RacingGame(carNames, tryCount);

        racingGame.race();

        ResultView.printWinners(racingGame.getWinners());
    }
}
