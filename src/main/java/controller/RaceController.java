package controller;

import model.Cars;
import model.Race;
import view.OutputView;

public class RaceController {

    private final Race race;
    private final Cars cars;

    public RaceController(String[] carNames, int raceCount) {
        this.race = new Race(carNames, raceCount);
        this.cars = new Cars(carNames);
    }

    public void startRace() {
        showRaceStartMessage();
    }

    public void showRaceStartMessage() {
        OutputView.printRaceStartMessage();
        race();
    }

    public void race() {
        for (int i = 0; i < race.getRaceCount(); i++) {
            cars.move();
            showRaceScore();
        }
    }

    public void showRaceScore() {
        OutputView.printRaceScore(cars.getCarNames(), cars.getCarScores());
    }

    public void showRaceWinners() {
        OutputView.printRaceWinner(cars.getWinners());
    }
}
