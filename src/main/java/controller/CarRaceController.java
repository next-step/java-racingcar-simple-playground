package controller;

import model.Car;
import model.CarRaceGame;
import model.CarRandomNumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarRaceController {
    private final CarRandomNumberGenerator carRandomNumberGenerator = new CarRandomNumberGenerator();
    private final List<Car> cars = new ArrayList<>();
    private CarRaceGame carRaceGame;
    private int roundCount;

    public void start() {
        performInputCarNames();
        performInputRoundCount();
        showRaceGameResult();
    }

    private void performInputCarNames() {
        List<String> carNames;

        while (true) {
            try {
                carNames = InputView.inputCarNames();
                break;
            } catch (Exception e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }

        for (String carName : carNames) {
            cars.add(new Car(carName, carRandomNumberGenerator));
        }

        carRaceGame = new CarRaceGame(cars);
    }

    private void performInputRoundCount() {

        while (true) {
            try {
                roundCount = InputView.inputRoundCount();
                break;
            } catch (Exception e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void showRaceGameResult() {
        OutputView.printResultTitle();

        for (int i = 1; i <= roundCount; i++) {
            List<Car> currentCars = carRaceGame.playSingleRoundAndGetCars();
            OutputView.printRaceStatus(currentCars);
        }

        OutputView.printWinners(carRaceGame.getWinners());
    }
}
