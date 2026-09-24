package controller;

import domain.Car;
import domain.CarRace;
import domain.Cars;
import domain.RoundCount;
import generator.RandomNumGenerator;
import java.util.ArrayList;
import view.View;

public class GameController {
    private RoundCount roundCount;
    private Cars cars;
    private View view;

    public GameController(View view) {
        cars = new Cars(new ArrayList<Car>());
        this.view = view;
    }

    public void run() {
        String names = view.inputCarNames();
        cars.addCars(names);
        roundCount = new RoundCount(view.inputRoundCount());
        playRace();
    }

    private void playRace() {
        view.printStartMessage();
        CarRace carRace = new CarRace(cars, new RandomNumGenerator());
        for (int i = 0; i < roundCount.getValue(); i++) {
            carRace.moveCars();
            view.printResult(cars);
        }
        view.printWinners(carRace.getWinners());
    }
}
