package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String namesInput = inputView.readCarNames();
        int countInput = inputView.readTryCount();
        List<Car> cars = CarsFactory.createCars(namesInput);
        CarRace carRace = new CarRace(cars, new RandomNumberGenerator());
        for (int i = 0; i < countInput; i++) {
            carRace.playRound();
            outputView.printCarsPosition(cars);
        }

        List<Car> winners = carRace.findWinners();
        outputView.printWinner(winners);

    }



}
