package org.duckstudy.controller;

import java.io.IOException;
import org.duckstudy.generator.Generator;
import org.duckstudy.model.Cars;
import org.duckstudy.view.InputView;
import org.duckstudy.view.OutputView;

public class RacingGame {

    private final InputView inputView;
    private final Validator validator;
    private final OutputView outputView;
    private final Generator generator;

    public RacingGame(InputView inputView, Validator validator, OutputView outputView,
                      Generator generator) {
        this.inputView = inputView;
        this.validator = validator;
        this.outputView = outputView;
        this.generator = generator;
    }

    public void run() throws IOException {
        String[] carNames = inputCarNames();
        int repetitionNum = inputRepetitionNum();

        Cars cars = new Cars(carNames, generator);
        playGame(repetitionNum, cars);
    }

    private String[] inputCarNames() throws IOException {
        try {
            String[] carNames = inputView.inputCarNames();
            return validator.validateCarNames(carNames);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputCarNames();
        }
    }

    private int inputRepetitionNum() throws IOException {
        try {
            int repetitionNum = inputView.inputRepetitionNum();
            return validator.validateRepetitionNum(repetitionNum);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputRepetitionNum();
        }
    }

    private void playGame(int repetitionNum, Cars cars) {
        outputView.printResultStartMessage();
        Cars winners = cars.playAndGetWinners(repetitionNum, outputView);
        outputView.printWinnerNames(winners.getNames());
    }
}
