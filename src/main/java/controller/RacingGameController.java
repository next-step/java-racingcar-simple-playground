package controller;

import domain.Car;
import domain.Cars;
import domain.generator.NumberGenerator;
import java.util.List;
import view.InputView;
import view.ResultView;

public class RacingGameController {
    private final InputView inputView;
    private final ResultView resultView;
    private final NumberGenerator numberGenerator;

    public RacingGameController(InputView inputView, ResultView resultView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        Cars cars = setUpCars();
        int tryCount = setUpTryCount();

        resultView.printResultHeader();
        for (int i = 0; i < tryCount; i++) {
            cars.moveAll(numberGenerator);
            resultView.printStatus(cars);
        }

        resultView.printWinners(cars.getWinners());
    }

    private Cars setUpCars() {
        List<String> names = inputView.readNames();
        List<Car> carList = names.stream()
                .map(Car::new)
                .toList();
        return new Cars(carList);
    }

    private int setUpTryCount() {
        return inputView.readTryCount();
    }
}
