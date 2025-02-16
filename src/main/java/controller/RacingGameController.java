package controller;

import java.util.List;
import java.util.stream.Collectors;

import model.Car;
import model.Cars;
import model.RacingGame;
import view.InputView;
import view.ResultView;

public class RacingGameController {

    private RacingGame racingGame;
    private Cars cars;

    public void startRacingGame() {

        List<String> carNames = InputView.getCars();
        cars = new Cars(carNames);

        int raceRounds = InputView.getRaceRounds();

        RacingGame racingGame = new RacingGame(cars);
        ResultView.printResultHeader();

        runRace(raceRounds, racingGame, cars);
        ResultView.printWinners(cars.getWinners());
        InputView.closeScanner();
    }

//    // 테스트용 초기화 메소드
//    public void initializeForTest(RacingGame racingGame) {
//        this.racingGame = racingGame;
//    }

    public void runRace(int raceRounds, RacingGame racingGame, Cars cars) {
        for (int i = 0; i < raceRounds; i++) {
            racingGame.race();
            ResultView.printRaceStatus(cars.getCars());
        }
    }
}
