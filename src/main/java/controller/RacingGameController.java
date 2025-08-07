package controller;

import java.util.List;

import model.Car;
import model.Cars;
import util.NameParser;
import util.TimesValidator;
import view.InputView;
import view.OutputView;

public class RacingGameController {

    private final Cars cars = new Cars();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        String nameStr = inputView.inputNames();
        List<String> names = parseName(nameStr);

        joinCars(names);

        String timesStr = inputView.inputTimes();
        int times = TimesValidator.validateAndGetTimes(timesStr);

        outputView.printExecuteResult();

        for (int i = 0; i < times; i++) {
            cars.moveCars();
            outputView.printProgress(cars.getCarList());
        }

        outputView.printWinners(cars.getWinners());
    }

    public void joinCars(List<String> names) {
        names.forEach(name ->
                cars.join(new Car(name))
        );
    }

    private List<String> parseName(String nameStr) {
        return NameParser.parse(nameStr);
    }
}
