package controller;

import view.Input;
import view.Output;

public class Application {
    public static void main(String[] args) {
        final var carNames = Input.getNames();
        final var gameCount = Input.getCount();

        final var carRace = new RaceGame(carNames, gameCount);

        final var result= new Output(carRace.getCars());

        result.winner();


    }
}
