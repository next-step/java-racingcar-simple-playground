package controller;

import java.util.List;
import model.Car;
import model.RacingGame;
import view.InputView;
import view.ResultView;

public class RacingGameController {
    // 게임 실행 및 결과 출력
    public void startRacingGame() {

        List<Car> carNames = InputView.getCars();
        int raceRounds = InputView.getRaceRounds();

        RacingGame racingGame = new RacingGame(carNames);
        ResultView.printRaceResult();

        for (int i = 0; i < raceRounds; i++) {
            racingGame.race();
            ResultView.printRaceStatus(racingGame.getCars());
        }

        List<Car> winners = racingGame.getWinners();
        ResultView.printWinners(winners);
    }
}
