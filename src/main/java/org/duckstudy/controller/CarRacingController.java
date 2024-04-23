package org.duckstudy.controller;

import java.io.IOException;
import org.duckstudy.model.car.Cars;
import org.duckstudy.model.generator.Generator;
import org.duckstudy.view.InputView;
import org.duckstudy.view.OutputView;

public class CarRacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Generator generator;

    public CarRacingController(InputView inputView, OutputView outputView,
                               Generator generator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = generator;
    }

    public void run() throws IOException {
        Cars cars = createCars();
        playGame(cars);
    }

    private Cars createCars() throws IOException {
        String[] carNames = inputView.inputCarNames();
        try {
            return new Cars(carNames, generator, outputView);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return createCars();
        }
    }

    private void playGame(Cars cars) throws IOException {
        Cars winners = makeGameAndPlay(cars);
        outputView.printWinnerNames(winners.getNames());
    }

    private Cars makeGameAndPlay(Cars cars) throws IOException {
        int repetitionNum = inputView.inputRepetitionNum();
        try {
            return cars.playAndGetWinners(repetitionNum, outputView);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return makeGameAndPlay(cars);
        }
    }
}
