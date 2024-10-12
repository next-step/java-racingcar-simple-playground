package controller;

import domain.Car;
import domain.CarParser;
import domain.Race;
import view.InputView;

import java.util.List;

import static view.OutPutMessage.*;
import static view.OutputView.printMessage;
import static view.OutputView.printNewLine;

public class Controller {
    public static void run() {
        printMessage(ASK_CARS_MESSAGE.getMessage());
        String input = InputView.inputCars();
        List<Car> cars = CarParser.parsing(input);

        printMessage(ASK_TRY_COUNT_MESSAGE.getMessage());
        int tryCount = InputView.inputTryCount();

        play(cars, tryCount);
    }

    private static void play(List<Car> cars, int tryCount) {
        Race race = Race.createRace(cars, tryCount);

        printNewLine();
        printMessage(RESULT_TITLE_MESSAGE.getMessage());

        race.start();
    }
}
