package car;

import car.domain.RacingGame;
import car.domain.strategy.RandomMovingStrategy;
import car.view.InputView;
import car.view.OutputView;

public class Application {

    public static void main(String[] args) {

        RacingGame game = new RacingGame(
            InputView.getCars(),
            InputView.getTryCount()
        );

        game.runRace(new RandomMovingStrategy());

        OutputView.printExecutionResultMessage();
        game.getResultHistory().forEach(round ->
            OutputView.printRoundResult(round.getCarSnapshots())
        );

        OutputView.printWinners(game.getWinners());
    }
}
