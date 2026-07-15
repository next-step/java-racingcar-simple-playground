import java.util.List;

import domain.Car;
import domain.RacingGame;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = InputView.readCars();
        int tryCount = InputView.tryCount();
        RacingGame racingGame = new RacingGame(cars);
        ResultView.printRaceResult();
        runRace(racingGame, cars, tryCount);
        ResultView.printWinners(racingGame.findWinners());
    }

    private static void runRace(RacingGame racingGame, List<Car> cars, int tryCount) {
        for (int count = 0; count < tryCount; count++) {
            racingGame.moveCars();
            ResultView.printCars(cars);
        }
    }
}
