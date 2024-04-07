package controller;

import model.Cars;
import model.Race;
import view.OutputView;

public class CarController {

    private final Race race;
    private final Cars cars;

    public CarController(String[] carNames, int raceCount) {
        this.race = new Race(carNames, raceCount);
        this.cars = new Cars(carNames);
    }

    public void raceStart() {
        showRaceStartMessage();
        moveCars();
    }

    public void moveCars() {
        for(int i = 0; i < race.getRaceCount(); i++){
            cars.move();
            showRaceScore();
        }
    }

    public void showRaceStartMessage(){
        OutputView.printRaceStartMessage();
    }

    public void showRaceScore(){
        OutputView.printRaceScore(cars.getCarNames(), cars.getCarScores());
    }

    public void printWinners() {
        System.out.println(cars.getWinners());
    }
}
