package controller;

import domain.Car;
import domain.CarNameParser;
import domain.CarRaceGame;
import java.util.List;
import view.inputView;
import view.outputView;

public class RacingGameController {

    public void startRacingGame() {
        String carNames = inputView.enterCarNames();
        List<Car> cars = CarNameParser.parseCarName(carNames);
        final CarRaceGame carRaceGame = new CarRaceGame(cars);

        int round = inputView.enterRoundNumber();

        outputView.printGameResultTitle();

        printGameRounds(carRaceGame, round, cars);

        printWinners(carRaceGame);
    }

    private void printGameRounds(CarRaceGame carRaceGame, int round, List<Car> cars) {
        carRaceGame.validateRoundNumber(round);

        for (int i = 0; i < round; i++) {

            carRaceGame.playOneRound();
            System.out.println();
            outputView.printRoundResult(cars);
        }
    }


    private void printWinners(CarRaceGame carRaceGame) {

        List<String> winnersName = carRaceGame.getWinnerNames();

        outputView.printGameWinners(winnersName);

    }
}
