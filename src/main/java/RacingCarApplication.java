import controller.RacingGame;
import java.util.List;
import model.RaceManager;
import model.dto.CarNameParser;
import strategy.RandomMoveStrategy;
import view.InputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        CarNameParser carNameParser = new CarNameParser(InputView.inputName());
        int tryCount = InputView.inputTryCount();
        List<String> carNames = carNameParser.splitNames();

        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        RaceManager raceManager = new RaceManager(carNames, tryCount, randomMoveStrategy);

        RacingGame racingGame = new RacingGame(raceManager);
        racingGame.run();
    }
}
