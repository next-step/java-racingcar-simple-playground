package controller;

import domain.Car;
import domain.Race;
import utils.RandomDigitGenerator;
import view.RaceInputView;
import view.RaceOutputView;

import java.util.List;

import static domain.Car.isValidCarNames;

public class RaceController {
    private final RaceInputView raceInputView;
    private final RaceOutputView raceOutputView;
    private final RandomDigitGenerator digitGenerator;
    private Race race;

    public RaceController(RaceInputView raceInputView, RaceOutputView raceOutputView, RandomDigitGenerator digitGenerator) {
        this.raceInputView = raceInputView;
        this.raceOutputView = raceOutputView;
        this.digitGenerator = digitGenerator;
    }

    public List<String> getValidCarNames() {
        raceOutputView.printGetCarNameMessage();
        List<String> carNames = raceInputView.getCarNames();
        while (!isValidCarNames(carNames)) {
            raceOutputView.printInvalidNameExceptionMessage();
            raceOutputView.printGetCarNameMessage();
            carNames = raceInputView.getCarNames();
        }
        return carNames;
    }

    public int getValidTurn() {
        raceOutputView.printGetRaceTurnMessage();
        int raceTurns = raceInputView.getRaceTurnNumber();
        while (raceTurns <= 0) {
            raceOutputView.printInvalidTurnExceptionMessage();
            raceOutputView.printGetRaceTurnMessage();
            raceTurns = raceInputView.getRaceTurnNumber();
        }
        return raceTurns;
    }

    public void runRace() {
        List<String> carNames = getValidCarNames();
        int raceTurns = getValidTurn();

        List<Car> cars = Car.generateCarList(carNames);
        this.race = new Race(cars.size(), raceTurns, digitGenerator);

        raceOutputView.printStartShowResultMessage();

        List<Car> winners = playRace(cars);
        raceOutputView.printEndShowResultMessage(winners);
    }

    private void printRaceOneTurn(List<Car> cars) {
        for (Car car : cars) {
            raceOutputView.printShowRaceStepsMessage(car);
        }
        System.out.println();
    }

    private List<Car> playRace(List<Car> cars) {
        for (int i = 0; i < race.getRaceTurn(); i++) {
            race.playSingleTurn(cars, digitGenerator);
            printRaceOneTurn(cars);
        }
        return race.getWinner(cars);
    }

}
