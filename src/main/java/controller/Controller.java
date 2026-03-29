package controller;

import view.InputView;
import view.OutputView;

import model.Car;

import model.RandomNumberGenerator;
import model.RacingGame;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public void run() {
        String input = InputView.getCarNames();
        String[] carNames = input.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        int number = InputView.getTrynumber();
        RacingGame racingGame= new RacingGame(cars);

        OutputView.printResultTitle();
        while(number>0){
            racingGame.playRound();
            OutputView.printRace(cars);
            number--;
        }
        OutputView.printWinners(racingGame.getResult());
    }
}
