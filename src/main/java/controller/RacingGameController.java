package controller;

import model.Car;
import model.RacingGame;
import model.RandomNumberGenerator;
import model.RandomNumberGenerator.DefaultRandomNumberGenerator;
import view.ResultView;

import java.util.List;

public class RacingGameController {

    public void startRacingGame(List<Car> cars, int raceRounds) {

        ResultView.printRaceResult();

        RandomNumberGenerator randomNumberGenerator = new DefaultRandomNumberGenerator();

        RacingGame racingGame = new RacingGame(cars, randomNumberGenerator);

        // 레이스 진행 (각 라운드마다 상태 출력)
        for (int i = 0; i < raceRounds; i++) {
            racingGame.raceSingleRound();
            ResultView.printRaceStatus(racingGame.getRaceStatus());
        }

        // 우승자 출력
        ResultView.printWinners(racingGame.getWinners());
    }
}
