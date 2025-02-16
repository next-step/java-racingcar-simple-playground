import domain.RacingGame;
import view.InputView;
import view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) throws Exception {
        final var carNames = InputView.getCarNames();
        final var tryCount = InputView.getRaceRounds();

        final var racingGame = new RacingGame(carNames, tryCount);
        racingGame.gameStart();

        ResultView.printWinners(racingGame.getWinner());
    }
}
