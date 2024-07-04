import java.util.List;

import model.Car;
import model.CarRace;
import view.GameView;

public class Application {
    public static void main(final String... args) {
        final List<Car> carNames = GameView.getCars();
        final int tryCount = GameView.getTryCount();

        final CarRace racingGame = new CarRace(carNames, tryCount);
        racingGame.raceStart();

        GameView.printWinners(racingGame.findWinner());
    }
}
