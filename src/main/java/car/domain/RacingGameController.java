package car.domain;

import car.view.InputView;
import car.view.OutputView;

public class RacingGameController {

    public void run() {

        CarGroup carGroup = InputView.getCars();
        int tryCount = InputView.getTryCount();

        RacingGame game = new RacingGame(carGroup);

        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            game.playOneRound(new RandomMovingStrategy());
            OutputView.printRoundResult(game.getCars());
        }

        OutputView.printWinners(game.getWinners());
    }

}
