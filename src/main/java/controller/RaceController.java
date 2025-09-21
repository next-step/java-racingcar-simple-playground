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

    public RaceController(
            RaceInputView raceInputView,
            RaceOutputView raceOutputView,
            RandomDigitGenerator digitGenerator
    ) {
        this.raceInputView = raceInputView;
        this.raceOutputView = raceOutputView;
        this.digitGenerator = digitGenerator;
    }

    public List<String> getValidCarNames() {
        List<String> carNames;

        do {
            raceOutputView.printGetCarNameMessage();
            carNames = raceInputView.getCarNames();
        } while (!validateCarNames(carNames));

        return carNames;
    }

    public int getValidTurn() {
        int raceTurns;
        do {
            raceOutputView.printGetRaceTurnMessage();
            raceTurns = raceInputView.getRaceTurnNumber();
        } while (!validateRaceTurns(raceTurns));

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

    private boolean validateCarNames(List<String> carNames) {
        if (!isValidCarNames(carNames)) {
            raceOutputView.printInvalidNameExceptionMessage();
            return false;
        }
        return true;
    }

    private boolean validateRaceTurns(int raceTruns) {
        if (raceTruns <= 0) {
            raceOutputView.printInvalidTurnExceptionMessage();
            return false;
        }
        return true;
    }

    private List<Car> playRace(List<Car> cars) {
        for (int i = 0; i < race.getRaceTurn(); i++) {
            race.playSingleTurn(cars, digitGenerator);
            raceOutputView.printRaceOneTurn(cars);
        }
        return race.getWinner(cars);
    }

}
