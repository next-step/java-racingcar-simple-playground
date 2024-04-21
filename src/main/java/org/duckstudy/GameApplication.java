package org.duckstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import org.duckstudy.generator.Generator;
import org.duckstudy.generator.RandomValueGenerator;
import org.duckstudy.input.InputValidator;
import org.duckstudy.input.InputView;
import org.duckstudy.movingcar.Car;
import org.duckstudy.movingcar.Cars;
import org.duckstudy.output.OutputView;

public class GameApplication {

    private final InputView inputView;
    private final InputValidator inputValidator;
    private final OutputView outputView;
    private final Generator generator;

    private GameApplication(InputView inputView, InputValidator inputValidator, OutputView outputView,
                            Generator generator) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.outputView = outputView;
        this.generator = generator;
    }

    public static void main(String[] args) throws IOException {
        OutputView outputView = new OutputView();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        InputView inputView = new InputView(bufferedReader, outputView);
        InputValidator inputValidator = new InputValidator(outputView);
        Generator generator = new RandomValueGenerator();

        GameApplication gameApplication = new GameApplication(inputView, inputValidator, outputView, generator);
        gameApplication.run();
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
            return inputValidator.validateCarNames(carNames);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputCarNames();
        }
    }

    private int inputRepetitionNum() throws IOException {
        try {
            int repetitionNum = inputView.inputRepetitionNum();
            return inputValidator.validateRepetitionNum(repetitionNum);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputRepetitionNum();
        }
    }

    private void playGame(int repetitionNum, Cars cars) {
        outputView.printResultStartMessage();

        Cars winners = cars.playAndGetWinners(repetitionNum, outputView);

        String winnerNames = winners.getCars()
                .stream().map(Car::getName)
                .collect(Collectors.joining(", "));
        outputView.printWinnerNames(winnerNames);
    }
}
