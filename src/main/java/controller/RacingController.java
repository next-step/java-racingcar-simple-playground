package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public RacingController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        String[] names = inputView.readCarNames();
        Cars cars = createCars(names);

        int raceCount = inputView.readRaceCount();

        RacingGame racingGame = new RacingGame(cars, numberGenerator);

        runRaceAndPrintResults(raceCount, racingGame, cars);

        outputView.printWinners(cars.findWinners());
    }

    private Cars createCars(String[] names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            carList.add(car);
        }

        Cars cars = new Cars(carList);

        return cars;
    }

    private void runRaceAndPrintResults(
            int raceCount,
            RacingGame racingGame,
            Cars cars
    ) {
        outputView.printResultHeader();
        for (int i = 0; i < raceCount; i++) {
            racingGame.race();
            outputView.printCars(cars);
        }
    }
}
