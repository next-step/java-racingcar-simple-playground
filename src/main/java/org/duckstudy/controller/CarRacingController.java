package org.duckstudy.controller;

import java.io.IOException;
import org.duckstudy.model.RepetitionCount;
import org.duckstudy.model.car.Cars;
import org.duckstudy.model.strategy.MovableStrategy;
import org.duckstudy.view.InputView;
import org.duckstudy.view.OutputView;

public class CarRacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MovableStrategy movableStrategy;

    public CarRacingController(InputView inputView, OutputView outputView,
                               MovableStrategy movableStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movableStrategy = movableStrategy;
    }

    public void run() throws IOException {
        Cars cars = createCars();
        RepetitionCount repetitionCount = createRepetitionCount();

        playGame(cars, repetitionCount);
    }

    private Cars createCars() throws IOException {
        String[] carNames = inputView.inputCarNames();
        try {
            return new Cars(carNames, movableStrategy);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return createCars();
        }
    }

    private RepetitionCount createRepetitionCount() throws IOException {
        int repetitionNum = inputView.inputRepetitionCount();
        try {
            return new RepetitionCount(repetitionNum);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return createRepetitionCount();
        }
    }

    private void playGame(Cars cars, RepetitionCount repetitionNum) {
        outputView.printResultStartMessage();

        for (int i = 0; i < repetitionNum.repetitionCount(); i++) {
            cars = cars.moveAll();
            outputView.printIntermediateResult(cars.toList());
        }

        Cars winners = cars.calculateWinners();
        outputView.printWinnerNames(winners.toList());
    }
}
