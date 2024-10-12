package controller;

import domain.Car;
import domain.CarParser;
import view.InputView;

import java.util.List;

import static view.OutPutMessage.ASK_CARS_MESSAGE;
import static view.OutPutMessage.ASK_TRY_COUNT_MESSAGE;
import static view.OutputView.printMessage;

public class Controller {
    public static void run() {
        printMessage(ASK_CARS_MESSAGE.getMessage());

        String input = InputView.inputCars();
        List<Car> cars = CarParser.parsing(input);

        printMessage(ASK_TRY_COUNT_MESSAGE.getMessage());

        int tryCount = InputView.inputTryCount();
    }
}
