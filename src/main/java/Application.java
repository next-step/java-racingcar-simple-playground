import domain.RacingCar;
import domain.RacingGame;
import java.util.List;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        RacingGame racingGame = new RacingGame(carNames, tryCount);

        ResultView.printHeader();
        for (int i = 0; i < racingGame.getTryCount(); i++) {
            racingGame.moveCars();
            ResultView.printRound(racingGame.getCars());
        }

        List<RacingCar> winners = racingGame.whoWin();
        ResultView.printWinners(winners);
    }
}
