package controller;

import objects.Car;
import objects.Cars;

public class RaceGame {

    private final String[] names;
    private final int gameCount;
    private static Cars carRepository;

    public Cars getCars() { return carRepository; }

    public RaceGame(String[] names, int gameCount) {
        this.gameCount = gameCount;
        this.names = names;
    }

    public void makeCarRepository() {

        carRepository = new Cars();

        for (int i = 0; i < names.length; i++) {
            Car myCar = new Car(names[i]);
            carRepository.getCars().add(myCar);
        }
    }

    public void runningRace() {

        for (int i = 0; i < gameCount; i++) {
            carRepository.race();
        }

        carRepository.makeWinningCars();
    }
}
