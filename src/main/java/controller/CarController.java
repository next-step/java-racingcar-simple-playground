package controller;

import model.Cars;
import model.Race;

public class CarController {

    private final Race race;
    private final Cars cars;

    public CarController(String[] carNames, int raceCount) {
        this.race = new Race(carNames, raceCount);
        this.cars = new Cars(carNames);
    }

    public void raceStart() {
        moveCars();
    }

    public void moveCars() {
        cars.moveCarsForRaces(race.getRaceCount());
    }

    public void printWinners() {
        System.out.println(cars.getWinners());
    }
}
