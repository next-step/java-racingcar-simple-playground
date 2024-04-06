import domain.RacingGame;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        final var carNames = new InputView().getCarNames();
        final var tryCnt = new InputView().getTryCnt();

        final var racingGame = new RacingGame(carNames, tryCnt);
        racingGame.race();

        new ResultView().printWinners(racingGame.getWinners());
    }
}
