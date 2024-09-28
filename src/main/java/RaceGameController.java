import domain.CarName;
import domain.Cars;
import domain.RaceGame;
import domain.RandomValueRule;
import view.InputView;
import view.ResultView;

import java.util.List;

public class RaceGameController {

    private final InputView inputView;
    private final ResultView resultView;

    public RaceGameController() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void run() {
        try {
            List<CarName> carNames = inputView.getCarsName();
            int tryCount = inputView.getTryCount();

            Cars cars = Cars.from(carNames);
            final RaceGame raceGame = new RaceGame(cars, tryCount, new RandomValueRule());

            raceGame.start();


            resultView.printWinners(raceGame.getWinners());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
