package controller;

import domain.Car;
import domain.Race;
import utils.RandomDigitGenerator;
import view.RaceInputView;
import view.RaceOutputView;

import java.util.List;

public class RaceController {
    private final RaceInputView raceInputView;
    private final RaceOutputView raceOutputView;
    private Race race;

    public RaceController() {
        raceInputView = new RaceInputView();
        raceOutputView = new RaceOutputView();

    }

    public void runRace() {
        raceOutputView.printGetCarNameMessage();
        List<String> carNames = raceInputView.getCarNames();

        raceOutputView.printGetRaceTurnMessage();
        int raceTurns = raceInputView.getRaceTurnNumber();

        List<Car> cars = Car.generateCarList(carNames);
        this.race = new Race(cars.size(), raceTurns, new RandomDigitGenerator());

        raceOutputView.printStartShowResultMessage();

        List<Car> winners = playRace(cars);
        raceOutputView.printEndShowResultMessage(winners);
    }

    private void printOneTurnRace(List<Car> cars) {
        for (Car car : cars) {
            raceOutputView.printShowRaceStepsMessage(car);
        }
        System.out.println();
    }

    private List<Car> playRace(List<Car> cars) {
        for (int i = 0; i < race.getRaceTurn(); i++) {
            race.playSingleTurn(cars);
            printOneTurnRace(cars);
        }
        return race.getWinner(cars);
    }
}
