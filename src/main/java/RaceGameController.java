import domain.Car;
import domain.CarName;
import domain.RaceGame;
import domain.RandomValueRule;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

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

            List<Car> cars = carNames.stream().map(Car::new).collect(Collectors.toList());
            final RaceGame raceGame = new RaceGame(cars, tryCount, new RandomValueRule());

            outputView.printResult();
            raceGame.start();


            outputView.printWinners(raceGame.getWinners());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
