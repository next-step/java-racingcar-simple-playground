package controller;

import view.Input;
import view.Output;

public class Application {
    public static void main(String[] args) {

        final String[] carNames = Input.getNames();
        final int gameCount = Input.getCount();

        final RaceGame carRace = new RaceGame(carNames, gameCount);
        carRace.makeCarRepository();
        carRace.runningRace();

        final Output result = new Output(carRace.getCars());

        result.winner();

    }
}
