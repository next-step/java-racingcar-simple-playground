import domain.CarName;
import domain.Cars;
import domain.RaceGame;
import domain.RandomValueRule;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RaceGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RaceGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        try {
            List<CarName> carNames = inputView.getCarsName();
            int tryCount = inputView.getTryCount();

            Cars cars = Cars.from(carNames);
            final RaceGame raceGame = new RaceGame(cars, tryCount, new RandomValueRule());

            outputView.printResult();
            raceGame.start();


            outputView.printWinners(raceGame.getWinners());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
