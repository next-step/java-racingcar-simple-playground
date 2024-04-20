package org.duckstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import org.duckstudy.generator.Generator;
import org.duckstudy.generator.RandomValueGenerator;
import org.duckstudy.input.InputView;
import org.duckstudy.movingcar.Car;
import org.duckstudy.movingcar.Cars;
import org.duckstudy.output.OutputView;

public class GameApplication {

    private final InputView inputView;
    private final OutputView outputView;

    private GameApplication(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static void main(String[] args) throws IOException {
        OutputView outputView = new OutputView();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        InputView inputView = new InputView(bufferedReader, outputView);

        GameApplication gameApplication = new GameApplication(inputView, outputView);
        gameApplication.run();
    }

    public void run() throws IOException {
        String[] nameList = inputView.inputCarNames();
        int repetitionNum = inputView.inputRepetitionNum();
        inputView.validateInput(nameList, repetitionNum);

        Generator generator = new RandomValueGenerator();
        Cars cars = new Cars(nameList.length, nameList, generator);
        playGame(cars, repetitionNum);
    }

    private void playGame(Cars cars, int repetitionNum) {
        outputView.printResultStartMessage();
        List<Car> winnerList = cars.play(repetitionNum, outputView);
        String winnerNames = winnerList.stream().map(Car::getName).collect(Collectors.joining(", "));
        outputView.printWinnerNames(winnerNames);
    }
}
