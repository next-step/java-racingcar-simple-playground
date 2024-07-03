import java.util.List;

import domain.Car;
import domain.RacingGame;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(final String... args) {
        final List<Car> carNames = InputView.getCarNames();
        final int tryCount = InputView.getTryCount();

        RacingGame race = new RacingGame(carNames);
        race.startRace(tryCount);

        ResultView.printWinners(race.getWinners());
    }
}
