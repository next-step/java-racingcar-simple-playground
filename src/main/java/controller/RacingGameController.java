package controller;

import java.util.List;

import model.Cars;
import model.RacingGame;
import model.RandomUtil;
import model.RandomValueGenerator;
import view.InputView;
import view.ResultView;

public class RacingGameController {

    private RacingGame racingGame;
    private Cars cars;

    public void startRacingGame() {

        List<String> carNames = InputView.getCars();
        cars = new Cars(carNames);

        int raceRounds = InputView.getRaceRounds();

        RandomUtil randomGenerator = new RandomValueGenerator();
        racingGame = new RacingGame(cars, randomGenerator);

        ResultView.printResultHeader();

        runRace(raceRounds, racingGame, cars);
        ResultView.printWinners(cars.getWinners());
        InputView.closeScanner();
    }

    public void runRace(int raceRounds, RacingGame racingGame, Cars cars) {
        for (int i = 0; i < raceRounds; i++) {
            racingGame.race();
            ResultView.printRaceStatus(cars.getCars());
        }
    }
}
