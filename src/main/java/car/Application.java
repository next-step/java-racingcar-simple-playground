package car;

import car.domain.RacingGame;
import car.domain.model.CarGroup;
import car.domain.strategy.RandomMovingStrategy;
import car.view.InputView;
import car.view.OutputView;

public class Application {

    public static void main(String[] args) {

        CarGroup carGroup = InputView.getCars();
        int tryCount = InputView.getTryCount();

        RacingGame game = new RacingGame(carGroup);

        OutputView.printExecutionResultMessage();

        for (int i = 0; i < tryCount; i++) {
            game.playOneRound(new RandomMovingStrategy());
            OutputView.printRoundResult(game.getCars());
        }

        OutputView.printWinners(game.getWinners());
    }
}
