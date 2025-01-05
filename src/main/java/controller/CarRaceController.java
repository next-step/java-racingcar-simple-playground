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

    public void start() {
        List<String> carNames = InputView.inputCarNames();
        int roundCount = InputView.inputRoundCount();
        List<Car> cars = new ArrayList<>();

        for (String carName: carNames) {
            cars.add(new Car(carName, carRandomNumberGenerator));
        }

        CarRaceGame carRaceGame = new CarRaceGame(cars);

        OutputView.printResultTitle();

        for (int i = 1; i <= roundCount; i++) {
            List<Car> currentCars = carRaceGame.playSingleRoundAndGetCars();
            OutputView.printRaceStatus((ArrayList<Car>) currentCars);
        }

        OutputView.printWinners(carRaceGame.getWinners());
    }
}
