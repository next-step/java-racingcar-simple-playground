import domain.RacingGame;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        String carNames = new InputView().getCarNames();
        int tryCnt = new InputView().getTryCnt();

        RacingGame racingGame = new RacingGame(carNames, tryCnt);
        racingGame.race();

        new ResultView().printWinners(racingGame.getWinners());
    }
}
