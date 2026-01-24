package car.controller;

import car.domain.RacingGame;
import car.domain.model.CarGroup;
import car.domain.model.Judge;
import car.domain.strategy.RandomMovingStrategy;
import car.view.InputView;
import car.view.OutputView;

public class RacingGameController {

    public void run() {

        CarGroup carGroup = InputView.getCars();
        int tryCount = InputView.getTryCount();
        Judge judge = new Judge();

        RacingGame game = new RacingGame(carGroup, judge);

        OutputView.printExecutionResultMessage();

        for (int i = 0; i < tryCount; i++) {
            game.playOneRound(new RandomMovingStrategy());
            OutputView.printRoundResult(game.getCars());
        }

        OutputView.printWinners(game.getWinners());
    }

}
