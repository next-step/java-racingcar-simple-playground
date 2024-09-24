import domain.Car;
import service.RacingGame;
import util.InputFromUser;
import util.SplitCarNames;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView.inputRacingCarNames();
        final List<String> carNames = InputFromUser.inputCarNames();

        InputView.inputTryingCount();
        final int executionsCount = InputFromUser.inputExecutionsCount();

        RacingGame racingGame = new RacingGame(carNames, executionsCount);
        List<Car> winnerCars = racingGame.start();

        OutputView.printWinnerCarNames(winnerCars);
    }
}
