package org.duckstudy.controller;

import java.io.IOException;
import org.duckstudy.model.car.Cars;
import org.duckstudy.model.generator.RandomValueGenerator;
import org.duckstudy.view.InputView;
import org.duckstudy.view.OutputView;

public class CarRacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomValueGenerator randomValueGenerator;

    public CarRacingController(InputView inputView, OutputView outputView,
                               RandomValueGenerator randomValueGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomValueGenerator = randomValueGenerator;
    }

    public void run() throws IOException {
        Cars cars = createCars();
        int repetitionNum = inputValidRepetitionNum(cars);

        playGame(cars, repetitionNum);
    }

    private Cars createCars() throws IOException {
        String[] carNames = inputView.inputCarNames();
        try {
            return new Cars(carNames, randomValueGenerator);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return createCars();
        }
    }

    private int inputValidRepetitionNum(Cars cars) throws IOException {
        int repetitionNum = inputView.inputRepetitionNum();
        try {
            return cars.validateRepetitionNum(repetitionNum);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputValidRepetitionNum(cars);
        }
    }

    private void playGame(Cars cars, int repetitionNum) {
        outputView.printResultStartMessage();

        for (int i = 0; i < repetitionNum; i++) {
            cars.moveAll();
            outputView.printIntermediateResult(cars.getAllNames(), cars.getAllPositions());
        }

        Cars winners = cars.calculateWinners();
        outputView.printWinnerNames(winners.getAllNames());
    }
}
