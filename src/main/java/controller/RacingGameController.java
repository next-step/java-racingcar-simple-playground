package controller;

import domain.car.CarMapper;
import domain.car.Cars;
import domain.racegame.MoveStrategy;
import domain.racegame.RacingGame;
import view.InputView;
import view.ResultView;

import java.util.List;

public class RacingGameController {

    private final MoveStrategy moveStrategy;

    public RacingGameController(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void racingApplication() {

        String carsNameInput = InputView.inputCarsNameFromUser();
        Cars cars = CarMapper.transformCarsNameListToCars(carsNameInput);

        int raceCount = InputView.inputRaceCountFromUser();

        RacingGame racingGame = new RacingGame(cars, raceCount);

        ResultView.printExecutionResultsMessage();

        startRacing(racingGame, cars);

        List<String> winners = racingGame.getWinners();
        ResultView.printWinners(winners);
    }

    private void startRacing(RacingGame racingGame, Cars cars) {

        while (racingGame.isRaceOngoing()) {
            racingGame.playOneRoundRace(moveStrategy);
            ResultView.printRaceResult(cars);
        }

    }

}
