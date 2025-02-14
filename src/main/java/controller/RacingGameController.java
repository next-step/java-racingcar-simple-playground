package controller;

import java.util.List;
import java.util.stream.Collectors;

import model.Car;
import model.Cars;
import model.RacingGame;
import view.InputView;
import view.ResultView;

public class RacingGameController {
    // 게임 실행 및 결과 출력
    public void startRacingGame() {

        List<String> carNames = InputView.getCars();
        Cars cars = new Cars(carNames);

        int raceRounds = InputView.getRaceRounds();

        RacingGame racingGame = new RacingGame(cars);
        ResultView.printResultHeader();

        for (int i = 0; i < raceRounds; i++) {
            racingGame.race();
            ResultView.printRaceStatus(cars.getCars());
        }

        ResultView.printWinners(cars.getWinners());
        InputView.closeScanner();
    }
}
